package unternehmensstruktur.views.all;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.router.*;
import unternehmensstruktur.model.dto.ItAssetDto;
import unternehmensstruktur.service.ItAssetService;
import unternehmensstruktur.views.single.SingleItAssetView;
import org.springframework.beans.factory.annotation.Autowired;

@Route("it-assets")
@PageTitle("IT Assets")
public class AllItAssetsView extends SimpleAllView<ItAssetDto> {

    @Autowired
    public AllItAssetsView(ItAssetService service) {
        super(ItAssetDto.class, "IT Assets", "it-assets", service::findAll);
        gridColumns.put("ICTO-Nummer",   ItAssetDto::getIctoNummer);
        gridColumns.put("Name",          ItAssetDto::getName);
        gridColumns.put("Status",        ItAssetDto::getStatus);
        gridColumns.put("Risikostufe",   ItAssetDto::getRisikostufe);
        detailsUrlProvider = dto -> dto.getIctoNummer();
        detailViewSupplier = () -> new SingleItAssetView(service);
        createButton = new Button("IT Asset hinzuf\u00fcgen");
        startPage();
    }
}
