package unternehmensstruktur.views.single;

import unternehmensstruktur.model.FieldType;
import unternehmensstruktur.model.dto.FilialeDto;
import unternehmensstruktur.service.FilialeService;

public class SingleFilialeView extends SimpleSingleView<FilialeDto> {

    public SingleFilialeView(FilialeService service) {
        super("filialen", FilialeDto.class,
                param -> service.findById(Integer.parseInt(param)),
                service::save,
                dto -> service.deleteById(dto.getStandortId()));
        setHeaderSupplier(() -> "Filiale #" + dto.getStandortId());
    }

    @Override
    protected void addFields() {
        addField("Standort-ID",        () -> dto.getStandortId(),       value -> {},                                        FieldType.INTEGER);
        addFkField("Firma",            () -> dto.getFirma(),            value -> dto.setFirma((String) value),              "firmen");
        addFkField("Adresse-ID",       () -> dto.getAdresseId(),        value -> dto.setAdresseId(toInt(value)),            "adressen");
        addFkField("Verantwortlicher", () -> dto.getVerantwortlicher(), value -> dto.setVerantwortlicher(toInt(value)),     "mitarbeiter");
        addField("Öffnungszeit",       () -> dto.getOeffnungszeit(),    value -> dto.setOeffnungszeit(toTime(value)));
        addField("Schließzeit",        () -> dto.getSchliesszeit(),     value -> dto.setSchliesszeit(toTime(value)));
        addField("Bestand Produkt A",  () -> dto.getBestandProduktA(),  value -> dto.setBestandProduktA(toInt(value)),     FieldType.INTEGER);
        addField("Bestand Produkt B",  () -> dto.getBestandProduktB(),  value -> dto.setBestandProduktB(toInt(value)),     FieldType.INTEGER);
        addField("Bestand Produkt C",  () -> dto.getBestandProduktC(),  value -> dto.setBestandProduktC(toInt(value)),     FieldType.INTEGER);
    }
}
