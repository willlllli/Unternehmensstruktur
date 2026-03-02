package unternehmensstruktur.service;

import unternehmensstruktur.model.db.Kunde;
import unternehmensstruktur.model.dto.KundeDto;
import unternehmensstruktur.repository.KundeRepository;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("unchecked")
public class KundeService extends BaseService<Kunde, KundeDto, KundeRepository, Integer> {

    public KundeService(KundeRepository repository, Mappingservice<?, ?> mappingservice) {
        super(repository, mappingservice);
    }

    @Override
    protected KundeDto toDto(Kunde entity) {
        return ((Mappingservice) mappingservice).map(entity);
    }

    @Override
    protected Kunde toEntity(KundeDto dto) {
        return ((Mappingservice) mappingservice).map(dto);
    }
}
