package unternehmensstruktur.model.dto;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class MitgliedDto extends BaseDto {

    private Integer mitarbeiterId;
    private Integer organisationseinheitId;

    public MitgliedDto() {
        super("/mitglieder", "Mitglied", "Mitglieder");
    }
}
