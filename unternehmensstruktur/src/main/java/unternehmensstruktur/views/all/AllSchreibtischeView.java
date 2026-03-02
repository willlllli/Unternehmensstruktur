package unternehmensstruktur.views.all;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.router.*;
import unternehmensstruktur.model.dto.SchreibtischDto;
import unternehmensstruktur.service.SchreibtischService;
import unternehmensstruktur.views.single.SingleSchreibtischView;
import org.springframework.beans.factory.annotation.Autowired;

@Route("schreibtische")
@PageTitle("Schreibtische")
public class AllSchreibtischeView extends SimpleAllView<SchreibtischDto> {

    @Autowired
    public AllSchreibtischeView(SchreibtischService service) {
        super(SchreibtischDto.class, "Schreibtische", "schreibtische", service::findAll);
        gridColumns.put("Bezeichnung", SchreibtischDto::getBezeichnung);
        gridColumns.put("Standort-ID", SchreibtischDto::getStandortId);
        gridColumns.put("H\u00f6henverstellbar", SchreibtischDto::getHoehenverstellbar);
        gridColumns.put("Monitore", SchreibtischDto::getAnzahlMonitore);
        gridColumns.put("LAN", SchreibtischDto::getLanVorhanden);
        gridColumns.put("WLAN", SchreibtischDto::getWlanVorhanden);
        detailsUrlProvider = dto -> dto.getBezeichnung() + "~" + dto.getStandortId();
        detailViewSupplier = () -> new SingleSchreibtischView(service);
        createButton = new Button("Schreibtisch hinzuf\u00fcgen");
        startPage();
    }
}
