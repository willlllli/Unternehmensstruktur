package unternehmensstruktur.service;

import unternehmensstruktur.model.db.Projekt;
import unternehmensstruktur.model.dto.ProjektDto;
import unternehmensstruktur.repository.ProjektRepository;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("unchecked")
public class ProjektService extends BaseService<Projekt, ProjektDto, ProjektRepository, String> {

    public ProjektService(ProjektRepository repository, Mappingservice<?, ?> mappingservice) {
        super(repository, mappingservice);
    }

    @Override
    protected ProjektDto toDto(Projekt entity) {
        return ((Mappingservice) mappingservice).map(entity);
    }

    @Override
    protected Projekt toEntity(ProjektDto dto) {
        return ((Mappingservice) mappingservice).map(dto);
    }
}
