package unternehmensstruktur.model.db;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "firma")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Firma {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "standort_id")
    private Integer standortId;
}
