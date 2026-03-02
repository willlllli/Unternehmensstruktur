package unternehmensstruktur.views.all;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.router.*;
import unternehmensstruktur.model.dto.KundeDto;
import unternehmensstruktur.service.KundeService;
import unternehmensstruktur.views.single.SingleKundeView;
import org.springframework.beans.factory.annotation.Autowired;

@Route("kunden")
@PageTitle("Kunden")
public class AllKundenView extends SimpleAllView<KundeDto> {

    @Autowired
    public AllKundenView(KundeService service) {
        super(KundeDto.class, "Kunden", "kunden", service::findAll);
        gridColumns.put("Kundennummer", KundeDto::getKundennummer);
        gridColumns.put("Firmenname",   KundeDto::getFirmenname);
        gridColumns.put("E-Mail",       KundeDto::getEmail);
        gridColumns.put("Mobilnummer",  KundeDto::getMobilnummer);
        detailsUrlProvider = dto -> String.valueOf(dto.getKundennummer());
        detailViewSupplier = () -> new SingleKundeView(service);
        createButton = new Button("Kunden hinzuf\u00fcgen");
        startPage();
    }
}
