package unternehmensstruktur.views.single;

import unternehmensstruktur.model.FieldType;
import unternehmensstruktur.model.db.ArbeitsplatzId;
import unternehmensstruktur.model.dto.SchreibtischDto;
import unternehmensstruktur.service.SchreibtischService;

public class SingleSchreibtischView extends SimpleSingleView<SchreibtischDto> {

    private final SchreibtischService service;

    public SingleSchreibtischView(SchreibtischService service) {
        super("schreibtische", SchreibtischDto.class,
                param -> { String[] p = param.split("~"); return service.findById(new ArbeitsplatzId(p[0], Integer.parseInt(p[1]))); },
                null,
                dto -> service.deleteById(new ArbeitsplatzId(dto.getBezeichnung(), dto.getStandortId())));
        this.service = service;
        setSaver(this::saveWithMode);
        setHeaderSupplier(() -> dto.getBezeichnung());
    }

    private void saveWithMode(SchreibtischDto dto) {
        if (createMode) {
            service.saveNew(dto);
        } else {
            service.save(dto);
        }
    }

    @Override
    protected void addFields() {
        addField("Bezeichnung",      () -> dto.getBezeichnung(),       value -> { if (createMode) dto.setBezeichnung((String) value); });
        addFkField("Standort-ID",    () -> dto.getStandortId(),        value -> { if (createMode) dto.setStandortId(toInt(value)); },          "standorte");
        addField("Höhenverstellbar", () -> dto.getHoehenverstellbar(), value -> dto.setHoehenverstellbar(toBool(value)), FieldType.BOOLEAN);
        addField("Anzahl Monitore",  () -> dto.getAnzahlMonitore(),    value -> dto.setAnzahlMonitore(toInt(value)),      FieldType.INTEGER);
        addField("LAN",              () -> dto.getLanVorhanden(),      value -> dto.setLanVorhanden(toBool(value)),       FieldType.BOOLEAN);
        addField("WLAN",             () -> dto.getWlanVorhanden(),     value -> dto.setWlanVorhanden(toBool(value)),      FieldType.BOOLEAN);
    }
}
