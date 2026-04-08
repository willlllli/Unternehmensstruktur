package unternehmensstruktur.views.all;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.router.*;
import unternehmensstruktur.model.dto.ArbeitsplatzDto;
import unternehmensstruktur.service.ArbeitsplatzService;
import unternehmensstruktur.views.single.SingleArbeitsplatzView;
import org.springframework.beans.factory.annotation.Autowired;

@Route("arbeitsplaetze")
@PageTitle("Arbeitspl\u00e4tze")
public class AllArbeitsplaetzeView extends SimpleAllView<ArbeitsplatzDto> {

    @Autowired
    public AllArbeitsplaetzeView(ArbeitsplatzService service) {
        super(ArbeitsplatzDto.class, "Arbeitspl\u00e4tze", "arbeitsplaetze", service::findAll);
        gridColumns.put("Bezeichnung", ArbeitsplatzDto::getBezeichnung);
        gridColumns.put("Standort-ID", ArbeitsplatzDto::getStandortId);
        gridColumns.put("LAN", ArbeitsplatzDto::getLanVorhanden);
        gridColumns.put("WLAN", ArbeitsplatzDto::getWlanVorhanden);
        detailsUrlProvider = dto -> dto.getBezeichnung() + "~" + dto.getStandortId();
        detailViewSupplier = () -> new SingleArbeitsplatzView(service);
        createButton = new Button("Arbeitsplatz hinzuf\u00fcgen");
        startPage();
    }
}
