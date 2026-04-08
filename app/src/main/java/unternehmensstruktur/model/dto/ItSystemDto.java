package unternehmensstruktur.model.dto;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class ItSystemDto extends BaseDto {

    private String ictoNummer;
    private String name;
    private String status;
    private Integer risikostufe;
    private Integer budget;
    private Integer organisationseinheitId;
    private Integer kundeId;
    private LocalDate endOfLifeDatum;

    public ItSystemDto() {
        super("/it-systeme", "IT System", "IT Systeme");
    }
}
