package unternehmensstruktur.model.db;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "standort")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Standort {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "standort_id")
    private Integer standortId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adresse_id", nullable = false)
    private Adresse adresse;

    // Stored as plain FK to break circular dependency with Mitarbeiter
    @Column(name = "verantwortlicher", nullable = false)
    private Integer verantwortlicher;

    @Column(name = "firma", nullable = false)
    private String firma;
}
