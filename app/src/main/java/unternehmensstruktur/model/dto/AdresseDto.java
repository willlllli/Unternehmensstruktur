package unternehmensstruktur.model.dto;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class AdresseDto extends BaseDto {

    private Integer adresseId;
    private String strasse;
    private String hausnummer;
    private Integer plz;
    private String stadt;
    private String bundesland;
    private String landIso;

    public AdresseDto() {
        super("/adressen", "Adresse", "Adressen");
    }
}
