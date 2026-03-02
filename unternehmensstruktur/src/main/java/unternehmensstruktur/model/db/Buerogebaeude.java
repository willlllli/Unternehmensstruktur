package unternehmensstruktur.model.db;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "buerogebaeude")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Buerogebaeude {

    @Id
    @Column(name = "standort_id")
    private Integer standortId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adresse_id", nullable = false)
    private Adresse adresse;

    @Column(name = "verantwortlicher", nullable = false)
    private Integer verantwortlicher;

    @Column(name = "firma", nullable = false)
    private String firma;

    @Column(name = "kantine_vorhanden")
    private Boolean kantineVorhanden;
}
