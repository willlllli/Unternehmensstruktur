package unternehmensstruktur.views.all;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.router.*;
import unternehmensstruktur.model.dto.AdresseDto;
import unternehmensstruktur.service.AdresseService;
import unternehmensstruktur.views.single.SingleAdressenView;
import org.springframework.beans.factory.annotation.Autowired;

@Route("adressen")
@PageTitle("Adressen")
public class AllAdressenView extends SimpleAllView<AdresseDto> {

    @Autowired
    public AllAdressenView(AdresseService service) {
        super(AdresseDto.class, "Adressen", "adressen", service::findAll);
        gridColumns.put("Adresse-ID",   AdresseDto::getAdresseId);
        gridColumns.put("Stra\u00dfe",   AdresseDto::getStrasse);
        gridColumns.put("Hausnummer",   AdresseDto::getHausnummer);
        gridColumns.put("PLZ",          AdresseDto::getPlz);
        gridColumns.put("Stadt",        AdresseDto::getStadt);
        gridColumns.put("Land (ISO)",   AdresseDto::getLandIso);
        detailsUrlProvider = dto -> String.valueOf(dto.getAdresseId());
        detailViewSupplier = () -> new SingleAdressenView(service);
        createButton = new Button("Adresse hinzuf\u00fcgen");
        startPage();
    }
}
