package unternehmensstruktur.service;

import unternehmensstruktur.model.dto.StandortauslastungDto;
import unternehmensstruktur.repository.StandortauslastungRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StandortauslastungService {

    private final StandortauslastungRepository standortauslastungRepository;

    public StandortauslastungService(StandortauslastungRepository standortauslastungRepository) {
        this.standortauslastungRepository = standortauslastungRepository;
    }

    public List<StandortauslastungDto> getAuslastung(LocalDate datum) {
        return standortauslastungRepository.findByIdDatum(datum)
                .stream()
                .map(v -> new StandortauslastungDto(
                        v.getId().getStandortId(),
                        v.getBuchungen(),
                        v.getGesamtArbeitsplaetze(),
                        v.getAuslastungProzent(),
                        v.getAuslastungsklasse()
                ))
                .toList();
    }
}
