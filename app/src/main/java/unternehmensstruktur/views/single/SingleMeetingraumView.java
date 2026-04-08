package unternehmensstruktur.views.single;

import unternehmensstruktur.model.FieldType;
import unternehmensstruktur.model.db.ArbeitsplatzId;
import unternehmensstruktur.model.dto.MeetingraumDto;
import unternehmensstruktur.service.MeetingraumService;

public class SingleMeetingraumView extends SimpleSingleView<MeetingraumDto> {

    private final MeetingraumService service;

    public SingleMeetingraumView(MeetingraumService service) {
        super("meetingraeume", MeetingraumDto.class,
                param -> { String[] p = param.split("~"); return service.findById(new ArbeitsplatzId(p[0], Integer.parseInt(p[1]))); },
                null,
                dto -> service.deleteById(new ArbeitsplatzId(dto.getBezeichnung(), dto.getStandortId())));
        this.service = service;
        setSaver(this::saveWithMode);
        setHeaderSupplier(() -> dto.getBezeichnung());
    }

    private void saveWithMode(MeetingraumDto dto) {
        if (createMode) {
            service.saveNew(dto);
        } else {
            service.save(dto);
        }
    }

    @Override
    protected void addFields() {
        addField("Bezeichnung",   () -> dto.getBezeichnung(),         value -> { if (createMode) dto.setBezeichnung((String) value); });
        addFkField("Standort-ID", () -> dto.getStandortId(),          value -> { if (createMode) dto.setStandortId(toInt(value)); },           "standorte");
        addField("Kapazität",    () -> dto.getKapazitaet(),          value -> dto.setKapazitaet(toInt(value)),           FieldType.INTEGER);
        addField("Webex Board",   () -> dto.getWebexBoardVorhanden(), value -> dto.setWebexBoardVorhanden(toBool(value)), FieldType.BOOLEAN);
        addField("LAN",           () -> dto.getLanVorhanden(),        value -> dto.setLanVorhanden(toBool(value)),        FieldType.BOOLEAN);
        addField("WLAN",          () -> dto.getWlanVorhanden(),       value -> dto.setWlanVorhanden(toBool(value)),       FieldType.BOOLEAN);
    }
}
