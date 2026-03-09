package unternehmensstruktur.model.dto;

import lombok.*;
import java.time.LocalTime;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class FilialeDto extends BaseDto {

    private Integer standortId;
    private Integer adresseId;
    private Integer verantwortlicher;
    private String firma;
    private LocalTime oeffnungszeit;
    private LocalTime schliesszeit;
    private Integer bestandProduktA;
    private Integer bestandProduktB;
    private Integer bestandProduktC;

    public FilialeDto() {
        super("/filialen", "Filiale", "Filialen");
    }
}
