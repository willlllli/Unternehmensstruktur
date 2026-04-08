package unternehmensstruktur.views.single;

import unternehmensstruktur.model.FieldType;
import unternehmensstruktur.model.db.BuchungId;
import unternehmensstruktur.model.dto.BuchungDto;
import unternehmensstruktur.service.BuchungService;

import java.time.LocalDate;

public class SingleBuchungView extends SimpleSingleView<BuchungDto> {

    private final BuchungService service;

    public SingleBuchungView(BuchungService service) {
        super("buchungen", BuchungDto.class,
                param -> { String[] p = param.split("~"); return service.findById(new BuchungId(p[0], Integer.parseInt(p[1]), LocalDate.parse(p[2]))); },
                null,
                dto -> service.deleteById(new BuchungId(dto.getBezeichnung(), dto.getStandortId(), dto.getDatum())));
        this.service = service;
        setSaver(this::saveWithMode);
        setHeaderSupplier(() -> dto.getBezeichnung());
    }

    private void saveWithMode(BuchungDto dto) {
        if (createMode) {
            service.saveNew(dto);
        } else {
            service.save(dto);
        }
    }

    @Override
    protected void addFields() {
        addField("Bezeichnung",      () -> dto.getBezeichnung(),   value -> { if (createMode) dto.setBezeichnung((String) value); });
        addFkField("Standort-ID",    () -> dto.getStandortId(),    value -> { if (createMode) dto.setStandortId(toInt(value)); },    "standorte");
        addField("Datum",            () -> dto.getDatum(),         value -> { if (createMode) dto.setDatum(toDate(value)); },        FieldType.DATE);
        addFkField("Mitarbeiter-ID", () -> dto.getMitarbeiterId(), value -> dto.setMitarbeiterId(toInt(value)), "mitarbeiter");
    }
}
