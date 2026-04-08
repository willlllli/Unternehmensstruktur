package unternehmensstruktur.model.dto;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class ArbeitsplatzDto extends BaseDto {

    private String bezeichnung;
    private Integer standortId;
    private Boolean lanVorhanden;
    private Boolean wlanVorhanden;

    public ArbeitsplatzDto() {
        super("/arbeitsplaetze", "Arbeitsplatz", "Arbeitspl\u00e4tze");
    }
}
