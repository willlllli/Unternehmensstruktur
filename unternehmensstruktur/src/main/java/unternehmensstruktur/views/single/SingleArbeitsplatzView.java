package unternehmensstruktur.views.single;

import unternehmensstruktur.model.db.ArbeitsplatzId;
import unternehmensstruktur.model.dto.ArbeitsplatzDto;
import unternehmensstruktur.service.ArbeitsplatzService;

public class SingleArbeitsplatzView extends SimpleSingleView<ArbeitsplatzDto> {

    public SingleArbeitsplatzView(ArbeitsplatzService service) {
        super("arbeitsplaetze", ArbeitsplatzDto.class,
                param -> { String[] p = param.split("~"); return service.findById(new ArbeitsplatzId(p[0], Integer.parseInt(p[1]))); },
                service::save,
                dto -> service.deleteById(new ArbeitsplatzId(dto.getBezeichnung(), dto.getStandortId())));
        setHeaderSupplier(() -> dto.getBezeichnung());
    }

    @Override
    protected void addFields() {
        addField("Bezeichnung",   () -> dto.getBezeichnung(),   value -> dto.setBezeichnung((String) value));
        addFkField("Standort-ID", () -> dto.getStandortId(),    value -> dto.setStandortId(toInt(value)),     "standorte");
        addField("LAN",           () -> dto.getLanVorhanden(),  value -> dto.setLanVorhanden(toBool(value)),  Boolean.class);
        addField("WLAN",          () -> dto.getWlanVorhanden(), value -> dto.setWlanVorhanden(toBool(value)), Boolean.class);
    }
}
