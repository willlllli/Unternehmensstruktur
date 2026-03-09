package unternehmensstruktur.views.single;

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
        addField("Standort-ID",          () -> dto.getStandortId(),        value -> {},                                           Integer.class);
        addFkField("Firma",              () -> dto.getFirma(),             value -> dto.setFirma((String) value),                 "firmen");
        addFkField("Adresse-ID",         () -> dto.getAdresseId(),         value -> dto.setAdresseId(toInt(value)),               "adressen");
        addFkField("Verantwortlicher",   () -> dto.getVerantwortlicher(),  value -> dto.setVerantwortlicher(toInt(value)),        "mitarbeiter");
        addField("\u00d6ffnungszeit",    () -> dto.getOeffnungszeit(),     value -> dto.setOeffnungszeit(toTime(value)));
        addField("Schlie\u00dfzeit",     () -> dto.getSchliesszeit(),      value -> dto.setSchliesszeit(toTime(value)));
        addField("Bestand Produkt A",    () -> dto.getBestandProduktA(),   value -> dto.setBestandProduktA(toInt(value)),         Integer.class);
        addField("Bestand Produkt B",    () -> dto.getBestandProduktB(),   value -> dto.setBestandProduktB(toInt(value)),         Integer.class);
        addField("Bestand Produkt C",    () -> dto.getBestandProduktC(),   value -> dto.setBestandProduktC(toInt(value)),         Integer.class);
    }
}
