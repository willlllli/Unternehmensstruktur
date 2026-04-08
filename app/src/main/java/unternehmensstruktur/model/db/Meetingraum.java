package unternehmensstruktur.model.db;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "meetingraum")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Meetingraum {

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

    @Column(name = "kapazitaet")
    private Integer kapazitaet;

    @Column(name = "webex_board_vorhanden")
    private Boolean webexBoardVorhanden;
}
