package unternehmensstruktur.service;

import unternehmensstruktur.model.db.Schreibtisch;
import unternehmensstruktur.model.db.ArbeitsplatzId;
import unternehmensstruktur.model.dto.SchreibtischDto;
import unternehmensstruktur.repository.SchreibtischRepository;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("unchecked")
public class SchreibtischService extends BaseService<Schreibtisch, SchreibtischDto, SchreibtischRepository, ArbeitsplatzId> {

    public SchreibtischService(SchreibtischRepository repository, Mappingservice<?, ?> mappingservice) {
        super(repository, mappingservice);
    }

    @Override
    protected SchreibtischDto toDto(Schreibtisch entity) {
        return ((Mappingservice) mappingservice).map(entity);
    }

    @Override
    protected Schreibtisch toEntity(SchreibtischDto dto) {
        return ((Mappingservice) mappingservice).map(dto);
    }
}
