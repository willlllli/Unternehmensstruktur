package unternehmensstruktur.views.single;

import unternehmensstruktur.model.FieldType;
import unternehmensstruktur.model.dto.ItSystemDto;
import unternehmensstruktur.service.ItSystemService;

public class SingleItSystemView extends SimpleSingleView<ItSystemDto> {

    private final ItSystemService service;

    public SingleItSystemView(ItSystemService service) {
        super("it-systeme", ItSystemDto.class,
                service::findById,
                null,
                dto -> service.deleteById(dto.getIctoNummer()));
        this.service = service;
        setSaver(this::saveWithMode);
        setHeaderSupplier(() -> dto.getName());
    }

    private void saveWithMode(ItSystemDto dto) {
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
        addField("End-of-Life",            () -> dto.getEndOfLifeDatum(),         value -> dto.setEndOfLifeDatum(toDate(value)),        FieldType.DATE);
        addFkField("Organisationseinheit", () -> dto.getOrganisationseinheitId(), value -> dto.setOrganisationseinheitId(toInt(value)), "organisationseinheiten");
        addFkField("Kunden-Nr",            () -> dto.getKundeId(),                value -> dto.setKundeId(toInt(value)),                "kunden");
    }
}
