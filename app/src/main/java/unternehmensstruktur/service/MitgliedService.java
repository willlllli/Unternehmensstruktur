package unternehmensstruktur.service;

import unternehmensstruktur.model.db.Mitglied;
import unternehmensstruktur.model.db.MitgliedId;
import unternehmensstruktur.model.dto.MitgliedDto;
import unternehmensstruktur.repository.MitgliedRepository;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("unchecked")
public class MitgliedService extends BaseService<Mitglied, MitgliedDto, MitgliedRepository, MitgliedId> {

    public MitgliedService(MitgliedRepository repository, Mappingservice<?, ?> mappingservice) {
        super(repository, mappingservice);
    }

    @Override
    protected MitgliedDto toDto(Mitglied entity) {
        return ((Mappingservice) mappingservice).map(entity);
    }

    @Override
    protected Mitglied toEntity(MitgliedDto dto) {
        return ((Mappingservice) mappingservice).map(dto);
    }
}
