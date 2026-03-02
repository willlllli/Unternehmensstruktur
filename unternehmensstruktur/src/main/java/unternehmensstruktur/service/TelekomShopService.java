package unternehmensstruktur.service;

import unternehmensstruktur.model.db.TelekomShop;
import unternehmensstruktur.model.dto.TelekomShopDto;
import unternehmensstruktur.repository.TelekomShopRepository;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("unchecked")
public class TelekomShopService extends BaseService<TelekomShop, TelekomShopDto, TelekomShopRepository, Integer> {

    public TelekomShopService(TelekomShopRepository repository, Mappingservice<?, ?> mappingservice) {
        super(repository, mappingservice);
    }

    @Override
    protected TelekomShopDto toDto(TelekomShop entity) {
        return ((Mappingservice) mappingservice).map(entity);
    }

    @Override
    protected TelekomShop toEntity(TelekomShopDto dto) {
        return ((Mappingservice) mappingservice).map(dto);
    }
}
