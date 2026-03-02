package unternehmensstruktur.views.all;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.router.*;
import unternehmensstruktur.model.dto.BuchungDto;
import unternehmensstruktur.service.BuchungService;
import unternehmensstruktur.views.single.SingleBuchungView;
import org.springframework.beans.factory.annotation.Autowired;

@Route("buchungen")
@PageTitle("Buchungen")
public class AllBuchungenView extends SimpleAllView<BuchungDto> {

    @Autowired
    public AllBuchungenView(BuchungService service) {
        super(BuchungDto.class, "Buchungen", "buchungen", service::findAll);
        gridColumns.put("Bezeichnung", BuchungDto::getBezeichnung);
        gridColumns.put("Standort-ID", BuchungDto::getStandortId);
        gridColumns.put("Datum", BuchungDto::getDatum);
        gridColumns.put("Mitarbeiter", BuchungDto::getMitarbeiterId);
        detailsUrlProvider = dto -> dto.getBezeichnung() + "~" + dto.getStandortId() + "~" + dto.getDatum();
        detailViewSupplier = () -> new SingleBuchungView(service);
        createButton = new Button("Buchung hinzuf\u00fcgen");
        startPage();
    }
}
