package unternehmensstruktur.views.all;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.router.*;
import unternehmensstruktur.model.dto.TelekomShopDto;
import unternehmensstruktur.service.TelekomShopService;
import unternehmensstruktur.views.single.SingleTelekomShopView;
import org.springframework.beans.factory.annotation.Autowired;

@Route("telekom-shops")
@PageTitle("Telekom Shops")
public class AllTelekomShopsView extends SimpleAllView<TelekomShopDto> {

    @Autowired
    public AllTelekomShopsView(TelekomShopService service) {
        super(TelekomShopDto.class, "Telekom Shops", "telekom-shops", service::findAll);
        gridColumns.put("Standort-ID",       TelekomShopDto::getStandortId);
        gridColumns.put("Firma",             TelekomShopDto::getFirma);
        gridColumns.put("Adresse-ID",        TelekomShopDto::getAdresseId);
        gridColumns.put("Bestand Router",    TelekomShopDto::getBestandRouter);
        gridColumns.put("Bestand Handys",    TelekomShopDto::getBestandHandys);
        gridColumns.put("Bestand SIM-Karten",TelekomShopDto::getBestandSimKarten);
        detailsUrlProvider = dto -> String.valueOf(dto.getStandortId());
        detailViewSupplier = () -> new SingleTelekomShopView(service);
        createButton = new Button("Telekom Shop hinzuf\u00fcgen");
        startPage();
    }
}
