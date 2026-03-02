package unternehmensstruktur.views.single;

import unternehmensstruktur.model.dto.MitarbeiterDto;
import unternehmensstruktur.service.MitarbeiterService;

import java.time.LocalDate;

public class SingleMitarbeiterView extends SimpleSingleView<MitarbeiterDto> {

    public SingleMitarbeiterView(MitarbeiterService service) {
        super("mitarbeiter", MitarbeiterDto.class,
                param -> service.findById(Integer.parseInt(param)),
                service::save,
                dto -> service.deleteById(dto.getPersonalnummer()));
        setHeaderSupplier(() -> dto.getName());
    }

    @Override
    protected void addFields() {
        addField("Personalnummer",          () -> dto.getPersonalnummer(),             value -> {},                                             Integer.class);
        addField("Name",                    () -> dto.getName(),                       value -> dto.setName((String) value));
        addField("A-Kennung",               () -> dto.getAKennung(),                   value -> dto.setAKennung((String) value));
        addField("Geburtsdatum",            () -> dto.getGeburtsdatum(),               value -> dto.setGeburtsdatum(toDate(value)),            LocalDate.class);
        addField("E-Mail (geschäftlich)",   () -> dto.getEmailGeschaeftlich(),         value -> dto.setEmailGeschaeftlich((String) value));
        addField("E-Mail (privat)",         () -> dto.getEmailPrivat(),                value -> dto.setEmailPrivat((String) value));
        addField("Mobil (geschäftlich)",    () -> dto.getMobilnummerGeschaeftlich(),   value -> dto.setMobilnummerGeschaeftlich((String) value));
        addField("Mobil (privat)",          () -> dto.getMobilnummerPrivat(),          value -> dto.setMobilnummerPrivat((String) value));
        addFkField("Standort-ID",           () -> dto.getStandortId(),                 value -> dto.setStandortId(toInt(value)),               "standorte");
        addFkField("Privatadresse-ID",      () -> dto.getPrivatadresseId(),            value -> dto.setPrivatadresseId(toInt(value)),          "adressen");
    }
}
