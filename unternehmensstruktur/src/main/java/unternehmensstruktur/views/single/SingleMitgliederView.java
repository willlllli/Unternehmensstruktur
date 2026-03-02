package unternehmensstruktur.views.single;

import unternehmensstruktur.model.db.MitgliedId;
import unternehmensstruktur.model.dto.MitgliedDto;
import unternehmensstruktur.service.MitgliedService;

public class SingleMitgliederView extends SimpleSingleView<MitgliedDto> {

    public SingleMitgliederView(MitgliedService service) {
        super("mitglieder", MitgliedDto.class,
                param -> { String[] p = param.split("~"); return service.findById(new MitgliedId(Integer.parseInt(p[0]), Integer.parseInt(p[1]))); },
                service::save,
                dto -> service.deleteById(new MitgliedId(dto.getMitarbeiterId(), dto.getOrganisationseinheitId())));
        setHeaderSupplier(() -> "Mitglied " + dto.getMitarbeiterId() + "/" + dto.getOrganisationseinheitId());
    }

    @Override
    protected void addFields() {
        addFkField("Mitarbeiter-ID",          () -> dto.getMitarbeiterId(),          value -> dto.setMitarbeiterId(toInt(value)),          "mitarbeiter");
        addFkField("Organisationseinheit-ID", () -> dto.getOrganisationseinheitId(), value -> dto.setOrganisationseinheitId(toInt(value)), "organisationseinheiten");
    }
}
