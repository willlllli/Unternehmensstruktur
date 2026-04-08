package unternehmensstruktur.views.all;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.router.*;
import unternehmensstruktur.model.dto.AbhaengigkeitDto;
import unternehmensstruktur.service.AbhaengigkeitService;
import unternehmensstruktur.views.single.SingleAbhaengigkeitView;
import org.springframework.beans.factory.annotation.Autowired;

@Route("abhaengigkeiten")
@PageTitle("Abh\u00e4ngigkeiten")
public class AllAbhaengigkeitenView extends SimpleAllView<AbhaengigkeitDto> {

    @Autowired
    public AllAbhaengigkeitenView(AbhaengigkeitService service) {
        super(AbhaengigkeitDto.class, "Abh\u00e4ngigkeiten", "abhaengigkeiten", service::findAll);
        gridColumns.put("Upstream IT Asset", AbhaengigkeitDto::getUpstreamItAsset);
        gridColumns.put("Downstream IT Asset", AbhaengigkeitDto::getDownstreamItAsset);
        detailsUrlProvider = dto -> dto.getUpstreamItAsset() + "~" + dto.getDownstreamItAsset();
        detailViewSupplier = () -> new SingleAbhaengigkeitView(service);
        createButton = new Button("Abh\u00e4ngigkeit hinzuf\u00fcgen");
        startPage();
    }
}
