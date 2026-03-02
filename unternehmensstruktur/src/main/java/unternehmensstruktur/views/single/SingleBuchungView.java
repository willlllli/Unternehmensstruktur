package unternehmensstruktur.views.single;

import unternehmensstruktur.model.db.BuchungId;
import unternehmensstruktur.model.dto.BuchungDto;
import unternehmensstruktur.service.BuchungService;

import java.time.LocalDate;

public class SingleBuchungView extends SimpleSingleView<BuchungDto> {

    public SingleBuchungView(BuchungService service) {
        super("buchungen", BuchungDto.class,
                param -> { String[] p = param.split("~"); return service.findById(new BuchungId(p[0], Integer.parseInt(p[1]), LocalDate.parse(p[2]))); },
                service::save,
                dto -> service.deleteById(new BuchungId(dto.getBezeichnung(), dto.getStandortId(), dto.getDatum())));
        setHeaderSupplier(() -> dto.getBezeichnung());
    }

    @Override
    protected void addFields() {
        addField("Bezeichnung",      () -> dto.getBezeichnung(),     value -> dto.setBezeichnung((String) value));
        addFkField("Standort-ID",    () -> dto.getStandortId(),      value -> dto.setStandortId(toInt(value)),      "standorte");
        addField("Datum",            () -> dto.getDatum(),           value -> dto.setDatum(toDate(value)),          LocalDate.class);
        addFkField("Mitarbeiter-ID", () -> dto.getMitarbeiterId(),   value -> dto.setMitarbeiterId(toInt(value)),   "mitarbeiter");
    }
}
