package unternehmensstruktur.model.db;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "organisationseinheit")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Organisationseinheit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "einheitsnummer")
    private Integer einheitsnummer;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "art", nullable = false)
    private String art;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "standort_id", nullable = false)
    private Standort standort;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uebergeordnete_oe")
    private Organisationseinheit uebergeordneteOe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "leiter", nullable = false)
    private Mitarbeiter leiter;
}
