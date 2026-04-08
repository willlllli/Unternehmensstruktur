package unternehmensstruktur.service;

import unternehmensstruktur.model.db.Arbeitsplatz;
import unternehmensstruktur.model.db.ArbeitsplatzId;
import unternehmensstruktur.model.dto.ArbeitsplatzDto;
import unternehmensstruktur.repository.ArbeitsplatzRepository;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("unchecked")
public class ArbeitsplatzService extends BaseService<Arbeitsplatz, ArbeitsplatzDto, ArbeitsplatzRepository, ArbeitsplatzId> {

    public ArbeitsplatzService(ArbeitsplatzRepository repository, Mappingservice<?, ?> mappingservice) {
        super(repository, mappingservice);
    }

    @Override
    protected ArbeitsplatzDto toDto(Arbeitsplatz entity) {
        return ((Mappingservice) mappingservice).map(entity);
    }

    @Override
    protected Arbeitsplatz toEntity(ArbeitsplatzDto dto) {
        return ((Mappingservice) mappingservice).map(dto);
    }
}
