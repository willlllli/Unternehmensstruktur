package unternehmensstruktur.views.all;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.router.*;
import unternehmensstruktur.model.dto.StandortDto;
import unternehmensstruktur.service.StandortService;
import unternehmensstruktur.views.single.SingleStandortView;
import org.springframework.beans.factory.annotation.Autowired;

@Route("standorte")
@PageTitle("Standorte")
public class AllStandorteView extends SimpleAllView<StandortDto> {

    @Autowired
    public AllStandorteView(StandortService service) {
        super(StandortDto.class, "Standorte", "standorte", service::findAll);
        gridColumns.put("Standort-ID",      StandortDto::getStandortId);
        gridColumns.put("Firma",            StandortDto::getFirma);
        gridColumns.put("Adresse-ID",       StandortDto::getAdresseId);
        gridColumns.put("Verantwortlicher", StandortDto::getVerantwortlicher);
        detailsUrlProvider = dto -> String.valueOf(dto.getStandortId());
        detailViewSupplier = () -> new SingleStandortView(service);
        createButton = new Button("Standort hinzuf\u00fcgen");
        startPage();
    }
}
