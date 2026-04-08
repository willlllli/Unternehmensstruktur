package unternehmensstruktur.views.single;

import unternehmensstruktur.model.FieldType;
import unternehmensstruktur.model.dto.StandortDto;
import unternehmensstruktur.service.StandortService;

public class SingleStandortView extends SimpleSingleView<StandortDto> {

    public SingleStandortView(StandortService service) {
        super("standorte", StandortDto.class,
                param -> service.findById(Integer.parseInt(param)),
                service::save,
                dto -> service.deleteById(dto.getStandortId()));
        setHeaderSupplier(() -> "Standort #" + dto.getStandortId());
    }

    @Override
    protected void addFields() {
        addField("Standort-ID",        () -> dto.getStandortId(),       value -> {},                                      FieldType.INTEGER);
        addFkField("Firma",            () -> dto.getFirma(),            value -> dto.setFirma((String) value),           "firmen");
        addFkField("Adresse-ID",       () -> dto.getAdresseId(),        value -> dto.setAdresseId(toInt(value)),         "adressen");
        addFkField("Verantwortlicher", () -> dto.getVerantwortlicher(), value -> dto.setVerantwortlicher(toInt(value)),  "mitarbeiter");
    }
}
