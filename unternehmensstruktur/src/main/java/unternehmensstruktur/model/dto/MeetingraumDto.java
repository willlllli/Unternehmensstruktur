package unternehmensstruktur.model.dto;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class MeetingraumDto extends BaseDto {

    private String bezeichnung;
    private Integer standortId;
    private Boolean lanVorhanden;
    private Boolean wlanVorhanden;
    private Integer kapazitaet;
    private Boolean webexBoardVorhanden;

    public MeetingraumDto() {
        super("/meetingraeume", "Meetingraum", "Meetingr\u00e4ume");
    }
}
