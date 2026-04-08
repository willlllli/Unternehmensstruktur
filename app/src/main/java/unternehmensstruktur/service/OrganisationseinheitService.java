package unternehmensstruktur.service;

import unternehmensstruktur.model.db.Organisationseinheit;
import unternehmensstruktur.model.dto.OrganisationseinheitDto;
import unternehmensstruktur.repository.OrganisationseinheitRepository;
import org.springframework.stereotype.Service;

@Service
public class OrganisationseinheitService extends BaseService<Organisationseinheit, OrganisationseinheitDto, OrganisationseinheitRepository, Integer> {

    public OrganisationseinheitService(OrganisationseinheitRepository repository, Mappingservice mappingservice) {
        super(repository, mappingservice);
    }

    @Override
    public OrganisationseinheitDto toDto(Organisationseinheit entity) {
        return mappingservice.map(entity);
    }

    @Override
    public Organisationseinheit toEntity(OrganisationseinheitDto dto) {
        return mappingservice.map(dto);
    }
}
