package unternehmensstruktur.views.all;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.router.*;
import unternehmensstruktur.model.dto.FirmaDto;
import unternehmensstruktur.service.FirmaService;
import unternehmensstruktur.views.single.SingleFirmaView;
import org.springframework.beans.factory.annotation.Autowired;

@Route("firmen")
@PageTitle("Firmen")
public class AllFirmenView extends SimpleAllView<FirmaDto> {

    @Autowired
    public AllFirmenView(FirmaService service) {
        super(FirmaDto.class, "Firmen", "firmen", service::findAll);
        gridColumns.put("Name",        FirmaDto::getName);
        gridColumns.put("Standort-ID", FirmaDto::getStandortId);
        detailsUrlProvider = dto -> dto.getName();
        detailViewSupplier = () -> new SingleFirmaView(service);
        createButton = new Button("Firma hinzuf\u00fcgen");
        startPage();
    }
}
