package unternehmensstruktur.views.single;

import unternehmensstruktur.model.db.MitgliedId;
import unternehmensstruktur.model.dto.MitgliedDto;
import unternehmensstruktur.service.MitgliedService;

public class SingleMitgliederView extends SimpleSingleView<MitgliedDto> {

    private final MitgliedService service;

    public SingleMitgliederView(MitgliedService service) {
        super("mitglieder", MitgliedDto.class,
                param -> { String[] p = param.split("~"); return service.findById(new MitgliedId(Integer.parseInt(p[0]), Integer.parseInt(p[1]))); },
                null,
                dto -> service.deleteById(new MitgliedId(dto.getMitarbeiterId(), dto.getOrganisationseinheitId())));
        this.service = service;
        setSaver(this::saveWithMode);
        setHeaderSupplier(() -> "Mitglied " + dto.getMitarbeiterId() + "/" + dto.getOrganisationseinheitId());
    }

    private void saveWithMode(MitgliedDto dto) {
        if (createMode) {
            service.saveNew(dto);
        } else {
            service.save(dto);
        }
    }

    @Override
    protected void addFields() {
        addFkField("Mitarbeiter-ID",          () -> dto.getMitarbeiterId(),          value -> { if (createMode) dto.setMitarbeiterId(toInt(value)); },          "mitarbeiter");
        addFkField("Organisationseinheit-ID", () -> dto.getOrganisationseinheitId(), value -> { if (createMode) dto.setOrganisationseinheitId(toInt(value)); }, "organisationseinheiten");
    }
}
