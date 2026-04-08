package unternehmensstruktur.service;

import unternehmensstruktur.model.db.Buerogebaeude;
import unternehmensstruktur.model.dto.BuerogebaeudeDto;
import unternehmensstruktur.repository.BuerogebaeudeRepository;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("unchecked")
public class BuerogebaeudeService extends BaseService<Buerogebaeude, BuerogebaeudeDto, BuerogebaeudeRepository, Integer> {

    public BuerogebaeudeService(BuerogebaeudeRepository repository, Mappingservice<?, ?> mappingservice) {
        super(repository, mappingservice);
    }

    @Override
    protected BuerogebaeudeDto toDto(Buerogebaeude entity) {
        return ((Mappingservice) mappingservice).map(entity);
    }

    @Override
    protected Buerogebaeude toEntity(BuerogebaeudeDto dto) {
        return ((Mappingservice) mappingservice).map(dto);
    }
}
