package unternehmensstruktur.model.dto;

import lombok.*;
import java.time.LocalTime;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class TelekomShopDto extends BaseDto {

    private Integer standortId;
    private Integer adresseId;
    private Integer verantwortlicher;
    private String firma;
    private LocalTime oeffnungszeit;
    private LocalTime schliesszeit;
    private Integer bestandRouter;
    private Integer bestandHandys;
    private Integer bestandSimKarten;

    public TelekomShopDto() {
        super("/telekom-shops", "Telekom Shop", "Telekom Shops");
    }
}
