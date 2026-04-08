package unternehmensstruktur.service;

import unternehmensstruktur.model.db.Standort;
import unternehmensstruktur.model.dto.StandortDto;
import unternehmensstruktur.repository.StandortRepository;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("unchecked")
public class StandortService extends BaseService<Standort, StandortDto, StandortRepository, Integer> {

    public StandortService(StandortRepository repository, Mappingservice<?, ?> mappingservice) {
        super(repository, mappingservice);
    }

    @Override
    protected StandortDto toDto(Standort entity) {
        return ((Mappingservice) mappingservice).map(entity);
    }

    @Override
    protected Standort toEntity(StandortDto dto) {
        return ((Mappingservice) mappingservice).map(dto);
    }
}
