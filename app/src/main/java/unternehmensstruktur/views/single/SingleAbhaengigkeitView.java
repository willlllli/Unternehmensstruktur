package unternehmensstruktur.views.single;

import unternehmensstruktur.model.db.AbhaengigkeitId;
import unternehmensstruktur.model.dto.AbhaengigkeitDto;
import unternehmensstruktur.service.AbhaengigkeitService;

public class SingleAbhaengigkeitView extends SimpleSingleView<AbhaengigkeitDto> {

    private final AbhaengigkeitService service;

    public SingleAbhaengigkeitView(AbhaengigkeitService service) {
        super("abhaengigkeiten", AbhaengigkeitDto.class,
                param -> { String[] p = param.split("~"); return service.findById(new AbhaengigkeitId(p[0], p[1])); },
                null,
                dto -> service.deleteById(new AbhaengigkeitId(dto.getUpstreamItAsset(), dto.getDownstreamItAsset())));
        this.service = service;
        setSaver(this::saveWithMode);
        setHeaderSupplier(() -> dto.getUpstreamItAsset() + " → " + dto.getDownstreamItAsset());
    }

    private void saveWithMode(AbhaengigkeitDto dto) {
        if (createMode) {
            service.saveNew(dto);
        } else {
            service.save(dto);
        }
    }

    @Override
    protected void addFields() {
        addIctoFkField("Upstream IT Asset",   () -> dto.getUpstreamItAsset(),   value -> { if (createMode) dto.setUpstreamItAsset((String) value); },   "it-assets");
        addIctoFkField("Downstream IT Asset", () -> dto.getDownstreamItAsset(), value -> { if (createMode) dto.setDownstreamItAsset((String) value); }, "it-assets");
    }
}
