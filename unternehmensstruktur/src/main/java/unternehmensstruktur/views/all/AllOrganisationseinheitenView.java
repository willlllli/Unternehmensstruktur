package unternehmensstruktur.views.all;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.router.*;
import unternehmensstruktur.model.dto.OrganisationseinheitDto;
import unternehmensstruktur.service.OrganisationseinheitService;
import unternehmensstruktur.views.single.SingleOrganisationseinheitView;
import org.springframework.beans.factory.annotation.Autowired;

@Route("organisationseinheiten")
@PageTitle("Organisationseinheiten")
public class AllOrganisationseinheitenView extends SimpleAllView<OrganisationseinheitDto> {

    @Autowired
    public AllOrganisationseinheitenView(OrganisationseinheitService service) {
        super(OrganisationseinheitDto.class, "Organisationseinheiten", "organisationseinheiten", service::findAll);
        gridColumns.put("Einheitsnummer", OrganisationseinheitDto::getEinheitsnummer);
        gridColumns.put("Name",           OrganisationseinheitDto::getName);
        gridColumns.put("Art",            OrganisationseinheitDto::getArt);
        gridColumns.put("Firma",          OrganisationseinheitDto::getFirma);
        gridColumns.put("Standort-ID",    OrganisationseinheitDto::getStandortId);
        detailsUrlProvider = dto -> String.valueOf(dto.getEinheitsnummer());
        detailViewSupplier = () -> new SingleOrganisationseinheitView(service);
        createButton = new Button("Organisationseinheit hinzuf\u00fcgen");
        startPage();
    }
}
