package unternehmensstruktur.views.single;

import unternehmensstruktur.model.db.AbhaengigkeitId;
import unternehmensstruktur.model.dto.AbhaengigkeitDto;
import unternehmensstruktur.service.AbhaengigkeitService;

public class SingleAbhaengigkeitView extends SimpleSingleView<AbhaengigkeitDto> {

    public SingleAbhaengigkeitView(AbhaengigkeitService service) {
        super("abhaengigkeiten", AbhaengigkeitDto.class,
                param -> { String[] p = param.split("~"); return service.findById(new AbhaengigkeitId(p[0], p[1])); },
                service::save,
                dto -> service.deleteById(new AbhaengigkeitId(dto.getUpstreamItAsset(), dto.getDownstreamItAsset())));
        setHeaderSupplier(() -> dto.getUpstreamItAsset() + " → " + dto.getDownstreamItAsset());
    }

    @Override
    protected void addFields() {
        addFkField("Upstream IT Asset",   () -> dto.getUpstreamItAsset(),   value -> dto.setUpstreamItAsset((String) value),    "it-assets");
        addFkField("Downstream IT Asset", () -> dto.getDownstreamItAsset(), value -> dto.setDownstreamItAsset((String) value),  "it-assets");
    }
}
