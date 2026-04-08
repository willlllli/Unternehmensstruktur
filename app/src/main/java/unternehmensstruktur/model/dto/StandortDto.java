package unternehmensstruktur.model.dto;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class StandortDto extends BaseDto {

    private Integer standortId;
    private Integer adresseId;
    private Integer verantwortlicher;
    private String firma;

    public StandortDto() {
        super("/standorte", "Standort", "Standorte");
    }
}
