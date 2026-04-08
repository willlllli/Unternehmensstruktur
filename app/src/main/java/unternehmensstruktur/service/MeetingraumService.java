package unternehmensstruktur.service;

import unternehmensstruktur.model.db.Meetingraum;
import unternehmensstruktur.model.db.ArbeitsplatzId;
import unternehmensstruktur.model.dto.MeetingraumDto;
import unternehmensstruktur.repository.MeetingraumRepository;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("unchecked")
public class MeetingraumService extends BaseService<Meetingraum, MeetingraumDto, MeetingraumRepository, ArbeitsplatzId> {

    public MeetingraumService(MeetingraumRepository repository, Mappingservice<?, ?> mappingservice) {
        super(repository, mappingservice);
    }

    @Override
    protected MeetingraumDto toDto(Meetingraum entity) {
        return ((Mappingservice) mappingservice).map(entity);
    }

    @Override
    protected Meetingraum toEntity(MeetingraumDto dto) {
        return ((Mappingservice) mappingservice).map(dto);
    }
}
