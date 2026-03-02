package unternehmensstruktur.model.dto;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class OrganisationseinheitDto extends BaseDto {

    private Integer einheitsnummer;
    private String name;
    private String art;
    private Integer standortId;
    private Integer uebergeordneteOeId;
    private String firma;
    private Integer leiterId;

    public OrganisationseinheitDto() {
        super("/organisationseinheiten", "Organisationseinheit", "Organisationseinheiten");
    }
}
