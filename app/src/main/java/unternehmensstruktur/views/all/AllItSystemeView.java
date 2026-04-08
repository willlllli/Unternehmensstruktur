package unternehmensstruktur.views.all;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.router.*;
import unternehmensstruktur.model.dto.ItSystemDto;
import unternehmensstruktur.service.ItSystemService;
import unternehmensstruktur.views.single.SingleItSystemView;
import org.springframework.beans.factory.annotation.Autowired;

@Route("it-systeme")
@PageTitle("IT Systeme")
public class AllItSystemeView extends SimpleAllView<ItSystemDto> {

    @Autowired
    public AllItSystemeView(ItSystemService service) {
        super(ItSystemDto.class, "IT Systeme", "it-systeme", service::findAll);
        gridColumns.put("ICTO-Nummer",   ItSystemDto::getIctoNummer);
        gridColumns.put("Name",          ItSystemDto::getName);
        gridColumns.put("Status",        ItSystemDto::getStatus);
        gridColumns.put("Risikostufe",   ItSystemDto::getRisikostufe);
        detailsUrlProvider = dto -> dto.getIctoNummer();
        detailViewSupplier = () -> new SingleItSystemView(service);
        createButton = new Button("IT System hinzuf\u00fcgen");
        startPage();
    }
}
