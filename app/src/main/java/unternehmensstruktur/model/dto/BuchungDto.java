package unternehmensstruktur.model.dto;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class BuchungDto extends BaseDto {

    private String bezeichnung;
    private Integer standortId;
    private LocalDate datum;
    private Integer mitarbeiterId;

    public BuchungDto() {
        super("/buchungen", "Buchung", "Buchungen");
    }
}
