package unternehmensstruktur.model.db;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalTime;

@Entity
@Table(name = "filiale")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Filiale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "standort_id")
    private Integer standortId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adresse_id", nullable = false)
    private Adresse adresse;

    @Column(name = "verantwortlicher", nullable = false)
    private Integer verantwortlicher;

    @Column(name = "firma", nullable = false)
    private String firma;

    @Column(name = "oeffnungszeit")
    private LocalTime oeffnungszeit;

    @Column(name = "schliesszeit")
    private LocalTime schliesszeit;

    @Column(name = "bestand_produkt_a")
    private Integer bestandProduktA;

    @Column(name = "bestand_produkt_b")
    private Integer bestandProduktB;

    @Column(name = "bestand_produkt_c")
    private Integer bestandProduktC;
}
