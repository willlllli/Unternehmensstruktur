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
public class MitgliedId implements Serializable {

    @Column(name = "mitarbeiter")
    private Integer mitarbeiter;

    @Column(name = "organisationseinheit")
    private Integer organisationseinheit;
}
