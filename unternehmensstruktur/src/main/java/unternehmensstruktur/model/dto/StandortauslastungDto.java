package unternehmensstruktur.model.dto;

import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StandortauslastungDto {

    private Integer standortId;
    private Long buchungen;
    private Long gesamtArbeitsplaetze;
    private BigDecimal auslastungProzent;
    private String auslastungsklasse;
}
