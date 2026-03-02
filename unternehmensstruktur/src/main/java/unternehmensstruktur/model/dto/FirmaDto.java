package unternehmensstruktur.model.dto;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class FirmaDto extends BaseDto {

    private String name;
    private Integer standortId;

    public FirmaDto() {
        super("/firmen", "Firma", "Firmen");
    }
}
