package unternehmensstruktur.views.single;

import unternehmensstruktur.model.FieldType;
import unternehmensstruktur.model.dto.BuerogebaeudeDto;
import unternehmensstruktur.service.BuerogebaeudeService;

public class SingleBuerogebaeudeView extends SimpleSingleView<BuerogebaeudeDto> {

    public SingleBuerogebaeudeView(BuerogebaeudeService service) {
        super("buerogebaeude", BuerogebaeudeDto.class,
                param -> service.findById(Integer.parseInt(param)),
                service::save,
                dto -> service.deleteById(dto.getStandortId()));
        setHeaderSupplier(() -> "Bürogebäude #" + dto.getStandortId());
    }

    @Override
    protected void addFields() {
        addField("Standort-ID",        () -> dto.getStandortId(),       value -> {},                                     FieldType.INTEGER);
        addFkField("Firma",            () -> dto.getFirma(),            value -> dto.setFirma((String) value),           "firmen");
        addFkField("Adresse-ID",       () -> dto.getAdresseId(),        value -> dto.setAdresseId(toInt(value)),         "adressen");
        addFkField("Verantwortlicher", () -> dto.getVerantwortlicher(), value -> dto.setVerantwortlicher(toInt(value)),  "mitarbeiter");
        addField("Kantine",            () -> dto.getKantineVorhanden(), value -> dto.setKantineVorhanden(toBool(value)), FieldType.BOOLEAN);
    }
}
