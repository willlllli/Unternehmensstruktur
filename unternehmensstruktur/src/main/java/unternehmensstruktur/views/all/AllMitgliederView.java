package unternehmensstruktur.views.all;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.router.*;
import unternehmensstruktur.model.dto.MitgliedDto;
import unternehmensstruktur.service.MitgliedService;
import unternehmensstruktur.views.single.SingleMitgliederView;
import org.springframework.beans.factory.annotation.Autowired;

@Route("mitglieder")
@PageTitle("Mitglieder")
public class AllMitgliederView extends SimpleAllView<MitgliedDto> {

    @Autowired
    public AllMitgliederView(MitgliedService service) {
        super(MitgliedDto.class, "Mitglieder", "mitglieder", service::findAll);
        gridColumns.put("Mitarbeiter", MitgliedDto::getMitarbeiterId);
        gridColumns.put("Organisationseinheit", MitgliedDto::getOrganisationseinheitId);
        detailsUrlProvider = dto -> dto.getMitarbeiterId() + "~" + dto.getOrganisationseinheitId();
        detailViewSupplier = () -> new SingleMitgliederView(service);
        createButton = new Button("Mitglied hinzuf\u00fcgen");
        startPage();
    }
}
