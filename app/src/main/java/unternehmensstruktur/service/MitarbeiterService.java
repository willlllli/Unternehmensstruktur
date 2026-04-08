package unternehmensstruktur.service;

import unternehmensstruktur.model.db.Mitarbeiter;
import unternehmensstruktur.model.dto.MitarbeiterDto;
import unternehmensstruktur.repository.MitarbeiterRepository;
import org.springframework.stereotype.Service;

@Service
public class MitarbeiterService extends BaseService<Mitarbeiter, MitarbeiterDto, MitarbeiterRepository, Integer> {

    public MitarbeiterService(MitarbeiterRepository repository, Mappingservice mappingservice) {
        super(repository, mappingservice);
    }

    @Override
    public MitarbeiterDto toDto(Mitarbeiter entity) {
        return mappingservice.map(entity);
    }

    @Override
    public Mitarbeiter toEntity(MitarbeiterDto dto) {
        return mappingservice.map(dto);
    }
}
