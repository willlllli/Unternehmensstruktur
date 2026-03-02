package unternehmensstruktur.views.single;

import unternehmensstruktur.model.db.ArbeitsplatzId;
import unternehmensstruktur.model.dto.MeetingraumDto;
import unternehmensstruktur.service.MeetingraumService;

public class SingleMeetingraumView extends SimpleSingleView<MeetingraumDto> {

    public SingleMeetingraumView(MeetingraumService service) {
        super("meetingraeume", MeetingraumDto.class,
                param -> { String[] p = param.split("~"); return service.findById(new ArbeitsplatzId(p[0], Integer.parseInt(p[1]))); },
                service::save,
                dto -> service.deleteById(new ArbeitsplatzId(dto.getBezeichnung(), dto.getStandortId())));
        setHeaderSupplier(() -> dto.getBezeichnung());
    }

    @Override
    protected void addFields() {
        addField("Bezeichnung",   () -> dto.getBezeichnung(),          value -> dto.setBezeichnung((String) value));
        addFkField("Standort-ID", () -> dto.getStandortId(),           value -> dto.setStandortId(toInt(value)),           "standorte");
        addField("Kapazität",  () -> dto.getKapazitaet(),          value -> dto.setKapazitaet(toInt(value)),           Integer.class);
        addField("Webex Board",   () -> dto.getWebexBoardVorhanden(),  value -> dto.setWebexBoardVorhanden(toBool(value)), Boolean.class);
        addField("LAN",           () -> dto.getLanVorhanden(),         value -> dto.setLanVorhanden(toBool(value)),        Boolean.class);
        addField("WLAN",          () -> dto.getWlanVorhanden(),        value -> dto.setWlanVorhanden(toBool(value)),       Boolean.class);
    }
}
