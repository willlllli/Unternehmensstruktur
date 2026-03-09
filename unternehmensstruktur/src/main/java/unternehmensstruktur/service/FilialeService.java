package unternehmensstruktur.service;

import unternehmensstruktur.model.db.Filiale;
import unternehmensstruktur.model.dto.FilialeDto;
import unternehmensstruktur.repository.FilialeRepository;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("unchecked")
public class FilialeService extends BaseService<Filiale, FilialeDto, FilialeRepository, Integer> {

    public FilialeService(FilialeRepository repository, Mappingservice<?, ?> mappingservice) {
        super(repository, mappingservice);
    }

    @Override
    protected FilialeDto toDto(Filiale entity) {
        return ((Mappingservice) mappingservice).map(entity);
    }

    @Override
    protected Filiale toEntity(FilialeDto dto) {
        return ((Mappingservice) mappingservice).map(dto);
    }
}
