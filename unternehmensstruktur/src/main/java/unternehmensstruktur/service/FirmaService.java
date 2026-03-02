package unternehmensstruktur.service;

import unternehmensstruktur.model.db.Firma;
import unternehmensstruktur.model.dto.FirmaDto;
import unternehmensstruktur.repository.FirmaRepository;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("unchecked")
public class FirmaService extends BaseService<Firma, FirmaDto, FirmaRepository, String> {

    public FirmaService(FirmaRepository repository, Mappingservice<?, ?> mappingservice) {
        super(repository, mappingservice);
    }

    @Override
    protected FirmaDto toDto(Firma entity) {
        return ((Mappingservice) mappingservice).map(entity);
    }

    @Override
    protected Firma toEntity(FirmaDto dto) {
        return ((Mappingservice) mappingservice).map(dto);
    }
}
