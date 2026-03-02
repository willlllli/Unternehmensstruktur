package unternehmensstruktur.model.dto;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class BuerogebaeudeDto extends BaseDto {

    private Integer standortId;
    private Integer adresseId;
    private Integer verantwortlicher;
    private String firma;
    private Boolean kantineVorhanden;

    public BuerogebaeudeDto() {
        super("/buerogebaeude", "B\u00fcrogeb\u00e4ude", "B\u00fcrogeb\u00e4ude");
    }
}
