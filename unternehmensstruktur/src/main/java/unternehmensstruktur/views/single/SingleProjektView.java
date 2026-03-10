package unternehmensstruktur.views.single;

import unternehmensstruktur.model.dto.ProjektDto;
import unternehmensstruktur.service.ProjektService;

import java.time.LocalDate;

public class SingleProjektView extends SimpleSingleView<ProjektDto> {

    public SingleProjektView(ProjektService service) {
        super("projekte", ProjektDto.class,
                service::findById,
                service::save,
                dto -> service.deleteById(dto.getIctoNummer()));
        setHeaderSupplier(() -> dto.getName());
    }

    @Override
    protected void addFields() {
        addField("ICTO-Nummer",            () -> dto.getIctoNummer(),             value -> { if (createMode) dto.setIctoNummer((String) value); });
        addField("Name",                   () -> dto.getName(),                   value -> dto.setName((String) value));
        addField("Status",                 () -> dto.getStatus(),                 value -> dto.setStatus((String) value));
        addField("Risikostufe",            () -> dto.getRisikostufe(),            value -> dto.setRisikostufe(toInt(value)),            Integer.class);
        addField("Budget",                 () -> dto.getBudget(),                 value -> dto.setBudget(toInt(value)),                 Integer.class);
        addField("Deadline",               () -> dto.getDeadline(),               value -> dto.setDeadline(toDate(value)),              LocalDate.class);
        addField("Fortschritt (%)",        () -> dto.getFortschritt(),            value -> dto.setFortschritt(toInt(value)),            Integer.class);
        addFkField("Organisationseinheit", () -> dto.getOrganisationseinheitId(), value -> dto.setOrganisationseinheitId(toInt(value)), "organisationseinheiten");
        addFkField("Kunden-Nr",            () -> dto.getKundeId(),                value -> dto.setKundeId(toInt(value)),                "kunden");
    }
}
