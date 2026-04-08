package unternehmensstruktur.model.db;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "arbeitsplatz")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Arbeitsplatz {

    @EmbeddedId
    private ArbeitsplatzId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("standortId")
    @JoinColumn(name = "standort_id")
    private Buerogebaeude buerogebaeude;

    @Column(name = "lan_vorhanden")
    private Boolean lanVorhanden;

    @Column(name = "wlan_vorhanden")
    private Boolean wlanVorhanden;
}
