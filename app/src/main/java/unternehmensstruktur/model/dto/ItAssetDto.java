package unternehmensstruktur.model.dto;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class ItAssetDto extends BaseDto {

    private String ictoNummer;
    private String name;
    private String status;
    private Integer risikostufe;
    private Integer budget;
    private Integer organisationseinheitId;
    private Integer kundeId;

    public ItAssetDto() {
        super("/it-assets", "IT Asset", "IT Assets");
    }
}
