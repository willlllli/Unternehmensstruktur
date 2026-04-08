package unternehmensstruktur.model.dto;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class MitarbeiterDto extends BaseDto {

    private Integer personalnummer;
    private String name;
    private String aKennung;
    private LocalDate geburtsdatum;
    private Integer privatadresseId;
    private String emailGeschaeftlich;
    private String emailPrivat;
    private String mobilnummerGeschaeftlich;
    private String mobilnummerPrivat;
    private Integer standortId;

    public MitarbeiterDto() {
        super("/mitarbeiter", "Mitarbeiter", "Mitarbeiter");
    }
}
