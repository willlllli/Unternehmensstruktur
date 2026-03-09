package unternehmensstruktur.views.all;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.router.*;
import unternehmensstruktur.model.dto.FilialeDto;
import unternehmensstruktur.service.FilialeService;
import unternehmensstruktur.views.single.SingleFilialeView;
import org.springframework.beans.factory.annotation.Autowired;

@Route("filialen")
@PageTitle("Filialen")
public class AllFilialenView extends SimpleAllView<FilialeDto> {

    @Autowired
    public AllFilialenView(FilialeService service) {
        super(FilialeDto.class, "Filialen", "filialen", service::findAll);
        gridColumns.put("Standort-ID",       FilialeDto::getStandortId);
        gridColumns.put("Firma",             FilialeDto::getFirma);
        gridColumns.put("Adresse-ID",        FilialeDto::getAdresseId);
        gridColumns.put("Bestand Produkt A", FilialeDto::getBestandProduktA);
        gridColumns.put("Bestand Produkt B", FilialeDto::getBestandProduktB);
        gridColumns.put("Bestand Produkt C", FilialeDto::getBestandProduktC);
        detailsUrlProvider = dto -> String.valueOf(dto.getStandortId());
        detailViewSupplier = () -> new SingleFilialeView(service);
        createButton = new Button("Filiale hinzuf\u00fcgen");
        startPage();
    }
}
