package unternehmensstruktur.model.dto;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class AbhaengigkeitDto extends BaseDto {

    private String upstreamItAsset;
    private String downstreamItAsset;

    public AbhaengigkeitDto() {
        super("/abhaengigkeiten", "Abh\u00e4ngigkeit", "Abh\u00e4ngigkeiten");
    }
}
