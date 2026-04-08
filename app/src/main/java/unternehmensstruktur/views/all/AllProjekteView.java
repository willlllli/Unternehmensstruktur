package unternehmensstruktur.views.all;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.router.*;
import unternehmensstruktur.model.dto.ProjektDto;
import unternehmensstruktur.service.ProjektService;
import unternehmensstruktur.views.single.SingleProjektView;
import org.springframework.beans.factory.annotation.Autowired;

@Route("projekte")
@PageTitle("Projekte")
public class AllProjekteView extends SimpleAllView<ProjektDto> {

    @Autowired
    public AllProjekteView(ProjektService service) {
        super(ProjektDto.class, "Projekte", "projekte", service::findAll);
        gridColumns.put("ICTO-Nummer",    ProjektDto::getIctoNummer);
        gridColumns.put("Name",           ProjektDto::getName);
        gridColumns.put("Status",         ProjektDto::getStatus);
        gridColumns.put("Fortschritt (%)",ProjektDto::getFortschritt);
        gridColumns.put("Deadline",       ProjektDto::getDeadline);
        detailsUrlProvider = dto -> dto.getIctoNummer();
        detailViewSupplier = () -> new SingleProjektView(service);
        createButton = new Button("Projekt hinzuf\u00fcgen");
        startPage();
    }
}
