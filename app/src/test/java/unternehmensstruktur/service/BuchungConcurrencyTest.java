package unternehmensstruktur.service;

import unternehmensstruktur.model.dto.BuchungDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Concurrency-Test: zwei Threads versuchen exakt gleichzeitig dieselbe
 * Buchung (identischer Composite-PK) anzulegen.
 *
 * Funktionsweise der Barrieren:
 *   Barrier 1 – beide Threads stehen unmittelbar vor saveNew() und warten
 *               aufeinander, bevor sie gleichzeitig eintreten.
 *   Barrier 2 – nach saveNew() warten beide, damit der Test erst dann
 *               auswertet, wenn beide Threads fertig sind.
 *
 * Erwartetes Verhalten
 * --------------------
 * MIT @Transactional(SERIALIZABLE) auf BaseService.saveNew():
 *   SERIALIZABLE erkennt den Read-Write-Konflikt zwischen den beiden
 *   Transaktionen. Eine Transaktion wird mit einer Exception abgebrochen
 *   (DataIntegrityViolationException oder IllegalArgumentException).
 *   → errors ist nicht leer → Test BESTEHT.
 *
 * OHNE @Transactional (bzw. READ_COMMITTED):
 *   Beide Threads führen existsById() aus, bevor der jeweils andere
 *   committed hat. Beide sehen keinen vorhandenen Eintrag, beide rufen
 *   saveAndFlush() auf. Einer der Saves überschreibt den anderen – oder
 *   die DB wirft einen Duplicate-Key-Fehler außerhalb der transaktionierten
 *   Absicherung. In H2 (in-memory) schlägt der zweite saveAndFlush() mit
 *   einer DataIntegrityViolationException fehl, die aber NICHT vom
 *   @Transactional-Rollback sauber behandelt wird. Da saveNew() ohne
 *   @Transactional aber trotzdem eine der beiden Buchungen einfach
 *   durchlässt (kein Rollback-Mechanismus greift), endet der Test mit
 *   errors.isEmpty() == true → Test SCHLÄGT FEHL.
 *
 * Voraussetzung: In der Datenbank muss ein Mitarbeiter mit ID 10000001
 * und ein Buerogebaeude mit standort_id 1 existieren (aus insert.sql).
 */
@SpringBootTest
class BuchungConcurrencyTest {

    @Autowired
    private BuchungService buchungService;

    /**
     * Beide Threads treten dank CyclicBarrier exakt gleichzeitig in
     * saveNew() ein. Mindestens einer muss mit einer Exception scheitern.
     */
    @Test
    void gleichzeitigeSpeicherungenMitGleichemPKMuessenFehlerErzeugen() throws Exception {

        // Barrier 1: beide Threads warten, bis beide bereit sind → dann gleichzeitig los
        // Barrier 2: beide Threads signalisieren "fertig" → dann auswerten
        CyclicBarrier startBarrier = new CyclicBarrier(2);
        CyclicBarrier doneBarrier  = new CyclicBarrier(2);

        List<Throwable> errors    = new CopyOnWriteArrayList<>();
        AtomicInteger   successes = new AtomicInteger(0);

        Runnable task = () -> {
            try {
                // ── Phase 1: Beide Threads synchronisieren sich unmittelbar
                //             VOR dem Aufruf von saveNew().
                startBarrier.await(5, TimeUnit.SECONDS);

                // ── Phase 2: Gleichzeitiger Einstieg in saveNew()
                buchungService.saveNew(buildDto());
                successes.incrementAndGet();

            } catch (DataIntegrityViolationException | IllegalArgumentException e) {
                // Erwartete Fehler – mindestens einer muss auftreten
                errors.add(e);
            } catch (BrokenBarrierException | InterruptedException e) {
                Thread.currentThread().interrupt();
                errors.add(new RuntimeException("Barrier-Fehler im Test-Thread", e));
            } catch (Exception e) {
                // Unerwartete Exceptions ebenfalls erfassen
                errors.add(e);
            } finally {
                try {
                    doneBarrier.await(10, TimeUnit.SECONDS);
                } catch (Exception ignored) {
                    // Wird ignoriert – Test-Auswertung erfolgt im Haupt-Thread
                }
            }
        };

        Thread t1 = new Thread(task, "buchung-thread-1");
        Thread t2 = new Thread(task, "buchung-thread-2");

        t1.start();
        t2.start();

        // Warten, bis beide Threads die doneBarrier passiert haben
        doneBarrier.await(15, TimeUnit.SECONDS);

        // ── Assertion ────────────────────────────────────────────────────────
        // Mit @Transactional(SERIALIZABLE): einer schlägt fehl  → errors nicht leer
        // Ohne @Transactional: beide "gelingen" (oder DB-Fehler ohne Rollback)
        //   → successes == 2 && errors.isEmpty() → Test schlägt fehl
        assertThat(errors)
                .as(
                    "Mindestens ein Thread muss mit DataIntegrityViolationException " +
                    "oder IllegalArgumentException scheitern, wenn zwei Threads " +
                    "gleichzeitig denselben Primärschlüssel anlegen wollen. " +
                    "Ist @Transactional(SERIALIZABLE) auf BaseService.saveNew() " +
                    "auskommentiert, können beide Threads unbemerkt durchlaufen."
                )
                .isNotEmpty();

        assertThat(errors)
                .allSatisfy(e ->
                    assertThat(e).isInstanceOfAny(
                        DataIntegrityViolationException.class,
                        IllegalArgumentException.class
                    )
                );
    }

    /**
     * Fester Composite-PK: bezeichnung + standortId + datum.
     * Beide Threads verwenden exakt dasselbe DTO, damit der Duplicate-PK
     * provoziert wird.
     */
    private BuchungDto buildDto() {
        BuchungDto dto = new BuchungDto();
        dto.setBezeichnung("A.01");
        dto.setStandortId(1);
        dto.setDatum(LocalDate.of(2099, 12, 31));
        dto.setMitarbeiterId(10000001);
        return dto;
    }
}
