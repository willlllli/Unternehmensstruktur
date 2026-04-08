package unternehmensstruktur.model.db;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ArbeitsplatzId implements Serializable {

    @Column(name = "bezeichnung")
    private String bezeichnung;

    @Column(name = "standort_id")
    private Integer standortId;
}
