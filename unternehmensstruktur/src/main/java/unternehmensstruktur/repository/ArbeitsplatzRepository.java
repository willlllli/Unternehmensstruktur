package unternehmensstruktur.repository;

import unternehmensstruktur.model.db.Arbeitsplatz;
import unternehmensstruktur.model.db.ArbeitsplatzId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ArbeitsplatzRepository extends BaseRepository<Arbeitsplatz, ArbeitsplatzId> {

    @Query(value = """
            SELECT standort_id, datum, buchungen, gesamt_arbeitsplaetze,
                   auslastung_prozent, auslastungsklasse
            FROM unternehmensstruktur.v_Standortauslastung
            WHERE datum = :datum
            """, nativeQuery = true)
    List<Object[]> findAuslastungByDatum(@Param("datum") LocalDate datum);
}
