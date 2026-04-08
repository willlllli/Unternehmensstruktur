package unternehmensstruktur.model.db;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "adresse")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adresse_id")
    private Integer adresseId;

    @Column(name = "strasse", nullable = false)
    private String strasse;

    @Column(name = "hausnummer", nullable = false)
    private String hausnummer;

    @Column(name = "plz", nullable = false)
    private Integer plz;

    @Column(name = "stadt", nullable = false)
    private String stadt;

    @Column(name = "bundesland")
    private String bundesland;

    @Column(name = "land_iso", nullable = false, length = 2)
    private String landIso;
}
