package unternehmensstruktur.service;

import unternehmensstruktur.model.db.Adresse;
import unternehmensstruktur.model.dto.AdresseDto;
import unternehmensstruktur.repository.AdresseRepository;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("unchecked")
public class AdresseService extends BaseService<Adresse, AdresseDto, AdresseRepository, Integer> {

    public AdresseService(AdresseRepository repository, Mappingservice<?, ?> mappingservice) {
        super(repository, mappingservice);
    }

    @Override
    protected AdresseDto toDto(Adresse entity) {
        return ((Mappingservice) mappingservice).map(entity);
    }

    @Override
    protected Adresse toEntity(AdresseDto dto) {
        return ((Mappingservice) mappingservice).map(dto);
    }
}
