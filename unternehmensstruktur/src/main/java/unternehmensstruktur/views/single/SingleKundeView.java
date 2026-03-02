package unternehmensstruktur.views.single;

import unternehmensstruktur.model.dto.KundeDto;
import unternehmensstruktur.service.KundeService;

public class SingleKundeView extends SimpleSingleView<KundeDto> {

    public SingleKundeView(KundeService service) {
        super("kunden", KundeDto.class,
                param -> service.findById(Integer.parseInt(param)),
                service::save,
                dto -> service.deleteById(dto.getKundennummer()));
        setHeaderSupplier(() -> dto.getFirmenname());
    }

    @Override
    protected void addFields() {
        addField("Kundennummer", () -> dto.getKundennummer(), value -> {},                                  Integer.class);
        addField("Firmenname",   () -> dto.getFirmenname(),   value -> dto.setFirmenname((String) value));
        addField("E-Mail",       () -> dto.getEmail(),        value -> dto.setEmail((String) value));
        addField("Mobilnummer",  () -> dto.getMobilnummer(),  value -> dto.setMobilnummer((String) value));
        addFkField("Adresse-ID",   () -> dto.getAdresseId(),    value -> dto.setAdresseId(toInt(value)),    "adressen");
    }
}
