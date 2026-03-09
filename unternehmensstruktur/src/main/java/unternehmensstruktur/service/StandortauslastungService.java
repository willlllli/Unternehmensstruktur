package unternehmensstruktur.service;

import unternehmensstruktur.model.dto.StandortauslastungDto;
import unternehmensstruktur.repository.ArbeitsplatzRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class StandortauslastungService {

    private final ArbeitsplatzRepository arbeitsplatzRepository;

    public StandortauslastungService(ArbeitsplatzRepository arbeitsplatzRepository) {
        this.arbeitsplatzRepository = arbeitsplatzRepository;
    }

    public List<StandortauslastungDto> getAuslastung(LocalDate datum) {
        return arbeitsplatzRepository.findAuslastungByDatum(datum)
                .stream()
                .map(row -> new StandortauslastungDto(
                        ((Number) row[0]).intValue(),
                        ((Number) row[1]).longValue(),
                        ((Number) row[2]).longValue(),
                        row[3] != null ? new BigDecimal(row[3].toString()) : null,
                        (String) row[4]
                ))
                .toList();
    }
}
