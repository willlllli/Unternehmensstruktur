package unternehmensstruktur.views.single;

import unternehmensstruktur.model.dto.OrganisationseinheitDto;
import unternehmensstruktur.service.OrganisationseinheitService;

public class SingleOrganisationseinheitView extends SimpleSingleView<OrganisationseinheitDto> {

    public SingleOrganisationseinheitView(OrganisationseinheitService service) {
        super("organisationseinheiten", OrganisationseinheitDto.class,
                param -> service.findById(Integer.parseInt(param)),
                service::save,
                dto -> service.deleteById(dto.getEinheitsnummer()));
        setHeaderSupplier(() -> dto.getName());
    }

    @Override
    protected void addFields() {
        addField("Einheitsnummer",           () -> dto.getEinheitsnummer(),      value -> {},                                              Integer.class);
        addField("Name",                     () -> dto.getName(),                value -> dto.setName((String) value));
        addField("Art",                      () -> dto.getArt(),                 value -> dto.setArt((String) value));
        addFkField("Firma",                    () -> dto.getFirma(),               value -> dto.setFirma((String) value),               "firmen");
        addFkField("Standort-ID",            () -> dto.getStandortId(),          value -> dto.setStandortId(toInt(value)),              "standorte");
        addFkField("Übergeordnete OE",  () -> dto.getUebergeordneteOeId(),  value -> dto.setUebergeordneteOeId(toInt(value)),      "organisationseinheiten");
        addFkField("Leiter (Personal-Nr)",   () -> dto.getLeiterId(),            value -> dto.setLeiterId(toInt(value)),                "mitarbeiter");
    }
}
