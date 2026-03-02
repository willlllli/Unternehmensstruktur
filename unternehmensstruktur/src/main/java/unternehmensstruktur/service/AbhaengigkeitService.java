package unternehmensstruktur.service;

import unternehmensstruktur.model.db.Abhaengigkeit;
import unternehmensstruktur.model.db.AbhaengigkeitId;
import unternehmensstruktur.model.dto.AbhaengigkeitDto;
import unternehmensstruktur.repository.AbhaengigkeitRepository;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("unchecked")
public class AbhaengigkeitService extends BaseService<Abhaengigkeit, AbhaengigkeitDto, AbhaengigkeitRepository, AbhaengigkeitId> {

    public AbhaengigkeitService(AbhaengigkeitRepository repository, Mappingservice<?, ?> mappingservice) {
        super(repository, mappingservice);
    }

    @Override
    protected AbhaengigkeitDto toDto(Abhaengigkeit entity) {
        return ((Mappingservice) mappingservice).map(entity);
    }

    @Override
    protected Abhaengigkeit toEntity(AbhaengigkeitDto dto) {
        return ((Mappingservice) mappingservice).map(dto);
    }
}
