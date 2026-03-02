package unternehmensstruktur.views.all;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.router.*;
import unternehmensstruktur.model.dto.MeetingraumDto;
import unternehmensstruktur.service.MeetingraumService;
import unternehmensstruktur.views.single.SingleMeetingraumView;
import org.springframework.beans.factory.annotation.Autowired;

@Route("meetingraeume")
@PageTitle("Meetingr\u00e4ume")
public class AllMeetingraeumenView extends SimpleAllView<MeetingraumDto> {

    @Autowired
    public AllMeetingraeumenView(MeetingraumService service) {
        super(MeetingraumDto.class, "Meetingr\u00e4ume", "meetingraeume", service::findAll);
        gridColumns.put("Bezeichnung", MeetingraumDto::getBezeichnung);
        gridColumns.put("Standort-ID", MeetingraumDto::getStandortId);
        gridColumns.put("Kapazit\u00e4t", MeetingraumDto::getKapazitaet);
        gridColumns.put("Webex Board", MeetingraumDto::getWebexBoardVorhanden);
        gridColumns.put("LAN", MeetingraumDto::getLanVorhanden);
        gridColumns.put("WLAN", MeetingraumDto::getWlanVorhanden);
        detailsUrlProvider = dto -> dto.getBezeichnung() + "~" + dto.getStandortId();
        detailViewSupplier = () -> new SingleMeetingraumView(service);
        createButton = new Button("Meetingraum hinzuf\u00fcgen");
        startPage();
    }
}
