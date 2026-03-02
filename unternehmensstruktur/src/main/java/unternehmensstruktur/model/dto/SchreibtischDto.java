package unternehmensstruktur.model.dto;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class SchreibtischDto extends BaseDto {

    private String bezeichnung;
    private Integer standortId;
    private Boolean lanVorhanden;
    private Boolean wlanVorhanden;
    private Boolean hoehenverstellbar;
    private Integer anzahlMonitore;

    public SchreibtischDto() {
        super("/schreibtische", "Schreibtisch", "Schreibtische");
    }
}
