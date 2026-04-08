package unternehmensstruktur.service;

import unternehmensstruktur.model.db.ItSystem;
import unternehmensstruktur.model.dto.ItSystemDto;
import unternehmensstruktur.repository.ItSystemRepository;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("unchecked")
public class ItSystemService extends BaseService<ItSystem, ItSystemDto, ItSystemRepository, String> {

    public ItSystemService(ItSystemRepository repository, Mappingservice<?, ?> mappingservice) {
        super(repository, mappingservice);
    }

    @Override
    protected ItSystemDto toDto(ItSystem entity) {
        return ((Mappingservice) mappingservice).map(entity);
    }

    @Override
    protected ItSystem toEntity(ItSystemDto dto) {
        return ((Mappingservice) mappingservice).map(dto);
    }
}
