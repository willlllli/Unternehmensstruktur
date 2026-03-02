package unternehmensstruktur.model.dto;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class KundeDto extends BaseDto {

    private Integer kundennummer;
    private String firmenname;
    private Integer adresseId;
    private String mobilnummer;
    private String email;

    public KundeDto() {
        super("/kunden", "Kunde", "Kunden");
    }
}
