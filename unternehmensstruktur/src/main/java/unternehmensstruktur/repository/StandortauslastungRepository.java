package unternehmensstruktur.repository;

import unternehmensstruktur.model.db.VStandortauslastung;
import unternehmensstruktur.model.db.VStandortauslastungId;

import java.time.LocalDate;
import java.util.List;

public interface StandortauslastungRepository extends BaseRepository<VStandortauslastung, VStandortauslastungId> {

    List<VStandortauslastung> findByIdDatum(LocalDate datum);
}
