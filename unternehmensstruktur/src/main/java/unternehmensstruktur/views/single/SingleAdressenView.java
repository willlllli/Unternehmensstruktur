package unternehmensstruktur.views.single;

import unternehmensstruktur.model.dto.AdresseDto;
import unternehmensstruktur.service.AdresseService;

public class SingleAdressenView extends SimpleSingleView<AdresseDto> {

    public SingleAdressenView(AdresseService service) {
        super("adressen", AdresseDto.class,
                param -> service.findById(Integer.parseInt(param)),
                service::save,
                dto -> service.deleteById(dto.getAdresseId()));
        setHeaderSupplier(() -> "Adresse #" + dto.getAdresseId());
    }

    @Override
    protected void addFields() {
        addField("Adresse-ID",  () -> dto.getAdresseId(),  value -> {},                                  Integer.class);
        addField("Straße",      () -> dto.getStrasse(),    value -> dto.setStrasse((String) value));
        addField("Hausnummer",  () -> dto.getHausnummer(), value -> dto.setHausnummer((String) value));
        addField("PLZ",         () -> dto.getPlz(),        value -> dto.setPlz(toInt(value)),            Integer.class);
        addField("Stadt",       () -> dto.getStadt(),      value -> dto.setStadt((String) value));
        addField("Bundesland",  () -> dto.getBundesland(), value -> dto.setBundesland((String) value));
        addField("Land (ISO)",  () -> dto.getLandIso(),    value -> dto.setLandIso((String) value));
    }
}
