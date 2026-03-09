package unternehmensstruktur.repository;

import unternehmensstruktur.model.db.Arbeitsplatz;
import unternehmensstruktur.model.db.ArbeitsplatzId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ArbeitsplatzRepository extends BaseRepository<Arbeitsplatz, ArbeitsplatzId> {

    @Query(value = """
            SELECT
                ap.standort_id,
                COUNT(b.bezeichnung)                                AS buchungen,
                COUNT(ap.bezeichnung)                               AS gesamt_arbeitsplaetze,
                ROUND(
                    COUNT(b.bezeichnung) * 100.0
                    / NULLIF(COUNT(ap.bezeichnung), 0), 1
                )                                                   AS auslastung_prozent,
                CASE
                    WHEN COUNT(ap.bezeichnung) = 0
                        THEN 'Keine Daten'
                    WHEN COUNT(b.bezeichnung) * 100.0
                         / COUNT(ap.bezeichnung) >= 90
                        THEN 'Ausgelastet'
                    WHEN COUNT(b.bezeichnung) * 100.0
                         / COUNT(ap.bezeichnung) >= 50
                        THEN 'Mittel'
                    ELSE 'Verfügbar'
                END                                                 AS auslastungsklasse
            FROM unternehmensstruktur.Arbeitsplatz ap
            LEFT JOIN unternehmensstruktur.Buchung b
                ON  ap.bezeichnung = b.bezeichnung
                AND ap.standort_id = b.standort_id
                AND b.datum        = :datum
            JOIN unternehmensstruktur.Standort s
                ON ap.standort_id = s.standort_id
            GROUP BY ap.standort_id
            """, nativeQuery = true)
    List<Object[]> findAuslastungByDatum(@Param("datum") LocalDate datum);
}
