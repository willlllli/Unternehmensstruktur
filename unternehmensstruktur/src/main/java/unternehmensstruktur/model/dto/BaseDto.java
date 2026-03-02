package unternehmensstruktur.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class BaseDto {
    private final transient String urlBase;
    private final transient String header;
    private final transient String headerPlural;

    private Integer id;
}
