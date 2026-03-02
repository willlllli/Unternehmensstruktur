package unternehmensstruktur.model.db;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "kunde")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Kunde {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kundennummer")
    private Integer kundennummer;

    @Column(name = "firmenname", nullable = false)
    private String firmenname;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adresse_id")
    private Adresse adresse;

    @Column(name = "mobilnummer", unique = true)
    private String mobilnummer;

    @Column(name = "email", unique = true)
    private String email;
}
