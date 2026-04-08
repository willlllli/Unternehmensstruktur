package unternehmensstruktur.service;

import unternehmensstruktur.model.db.ItAsset;
import unternehmensstruktur.model.dto.ItAssetDto;
import unternehmensstruktur.repository.ItAssetRepository;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("unchecked")
public class ItAssetService extends BaseService<ItAsset, ItAssetDto, ItAssetRepository, String> {

    public ItAssetService(ItAssetRepository repository, Mappingservice<?, ?> mappingservice) {
        super(repository, mappingservice);
    }

    @Override
    protected ItAssetDto toDto(ItAsset entity) {
        return ((Mappingservice) mappingservice).map(entity);
    }

    @Override
    protected ItAsset toEntity(ItAssetDto dto) {
        return ((Mappingservice) mappingservice).map(dto);
    }
}
