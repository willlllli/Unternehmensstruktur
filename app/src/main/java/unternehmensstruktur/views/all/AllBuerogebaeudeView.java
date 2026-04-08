package unternehmensstruktur.views.all;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.router.*;
import unternehmensstruktur.model.dto.BuerogebaeudeDto;
import unternehmensstruktur.service.BuerogebaeudeService;
import unternehmensstruktur.views.single.SingleBuerogebaeudeView;
import org.springframework.beans.factory.annotation.Autowired;

@Route("buerogebaeude")
@PageTitle("B\u00fcrogeb\u00e4ude")
public class AllBuerogebaeudeView extends SimpleAllView<BuerogebaeudeDto> {

    @Autowired
    public AllBuerogebaeudeView(BuerogebaeudeService service) {
        super(BuerogebaeudeDto.class, "B\u00fcrogeb\u00e4ude", "buerogebaeude", service::findAll);
        gridColumns.put("Standort-ID",      BuerogebaeudeDto::getStandortId);
        gridColumns.put("Firma",            BuerogebaeudeDto::getFirma);
        gridColumns.put("Adresse-ID",       BuerogebaeudeDto::getAdresseId);
        gridColumns.put("Verantwortlicher", BuerogebaeudeDto::getVerantwortlicher);
        gridColumns.put("Kantine",          BuerogebaeudeDto::getKantineVorhanden);
        detailsUrlProvider = dto -> String.valueOf(dto.getStandortId());
        detailViewSupplier = () -> new SingleBuerogebaeudeView(service);
        createButton = new Button("B\u00fcrogeb\u00e4ude hinzuf\u00fcgen");
        startPage();
    }
}
