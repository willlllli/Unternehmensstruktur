package unternehmensstruktur.model.db;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class VStandortauslastungId implements Serializable {

    @Column(name = "standort_id")
    private Integer standortId;

    @Column(name = "datum")
    private LocalDate datum;
}
