package unternehmensstruktur.views.all;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.router.*;
import unternehmensstruktur.model.dto.MitarbeiterDto;
import unternehmensstruktur.service.MitarbeiterService;
import unternehmensstruktur.views.single.SingleMitarbeiterView;
import org.springframework.beans.factory.annotation.Autowired;

@Route("mitarbeiter")
@RouteAlias("")
@PageTitle("Mitarbeiter")
public class AllMitarbeiterView extends SimpleAllView<MitarbeiterDto> {

    @Autowired
    public AllMitarbeiterView(MitarbeiterService service) {
        super(MitarbeiterDto.class, "Mitarbeiter", "mitarbeiter", service::findAll);
        gridColumns.put("Personalnummer", MitarbeiterDto::getPersonalnummer);
        gridColumns.put("Name", MitarbeiterDto::getName);
        gridColumns.put("A-Kennung", MitarbeiterDto::getAKennung);
        gridColumns.put("E-Mail (gesch\u00e4ftlich)", MitarbeiterDto::getEmailGeschaeftlich);
        gridColumns.put("Standort", MitarbeiterDto::getStandortId);
        detailsUrlProvider = dto -> String.valueOf(dto.getPersonalnummer());
        detailViewSupplier = () -> new SingleMitarbeiterView(service);
        createButton = new Button("Mitarbeiter hinzuf\u00fcgen");
        startPage();
    }
}
