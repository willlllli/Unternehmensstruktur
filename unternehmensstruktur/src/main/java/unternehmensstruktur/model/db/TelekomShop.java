package unternehmensstruktur.model.db;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalTime;

@Entity
@Table(name = "telekom_shop")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TelekomShop {

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

    @Column(name = "bestand_router")
    private Integer bestandRouter;

    @Column(name = "bestand_handys")
    private Integer bestandHandys;

    @Column(name = "bestand_sim_karten")
    private Integer bestandSimKarten;
}
