package unternehmensstruktur.service;

import unternehmensstruktur.model.db.Buchung;
import unternehmensstruktur.model.db.BuchungId;
import unternehmensstruktur.model.dto.BuchungDto;
import unternehmensstruktur.repository.BuchungRepository;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("unchecked")
public class BuchungService extends BaseService<Buchung, BuchungDto, BuchungRepository, BuchungId> {

    public BuchungService(BuchungRepository repository, Mappingservice<?, ?> mappingservice) {
        super(repository, mappingservice);
    }

    @Override
    protected BuchungDto toDto(Buchung entity) {
        return ((Mappingservice) mappingservice).map(entity);
    }

    @Override
    protected Buchung toEntity(BuchungDto dto) {
        return ((Mappingservice) mappingservice).map(dto);
    }
}
