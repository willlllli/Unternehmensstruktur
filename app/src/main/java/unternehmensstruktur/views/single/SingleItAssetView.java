package unternehmensstruktur.views.single;

import unternehmensstruktur.model.FieldType;
import unternehmensstruktur.model.dto.ItAssetDto;
import unternehmensstruktur.service.ItAssetService;

public class SingleItAssetView extends SimpleSingleView<ItAssetDto> {

    private final ItAssetService service;

    public SingleItAssetView(ItAssetService service) {
        super("it-assets", ItAssetDto.class,
                service::findById,
                /* Speichern je nach Modus (Create/Update) */
                null,
                dto -> service.deleteById(dto.getIctoNummer()));
        this.service = service;
        setSaver(this::saveWithMode);
        setHeaderSupplier(() -> dto.getName());
    }

    private void saveWithMode(ItAssetDto dto) {
        if (createMode) {
            service.saveNew(dto);
        } else {
            service.save(dto);
        }
    }

    @Override
    protected void addFields() {
        addField("ICTO-Nummer",            () -> dto.getIctoNummer(),             value -> { if (createMode) dto.setIctoNummer((String) value); }, FieldType.ICTO_NUMBER);
        addField("Name",                   () -> dto.getName(),                   value -> dto.setName((String) value));
        addField("Status",                 () -> dto.getStatus(),                 value -> dto.setStatus((String) value));
        addField("Risikostufe",            () -> dto.getRisikostufe(),            value -> dto.setRisikostufe(toInt(value)),            FieldType.INTEGER);
        addField("Budget",                 () -> dto.getBudget(),                 value -> dto.setBudget(toInt(value)),                 FieldType.INTEGER);
        addFkField("Organisationseinheit", () -> dto.getOrganisationseinheitId(), value -> dto.setOrganisationseinheitId(toInt(value)), "organisationseinheiten");
        addFkField("Kunden-Nr",            () -> dto.getKundeId(),                value -> dto.setKundeId(toInt(value)),                "kunden");
    }
}
