package unternehmensstruktur.model.db;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "buchung")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Buchung {

    @EmbeddedId
    private BuchungId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("standortId")
    @JoinColumn(name = "standort_id")
    private Buerogebaeude buerogebaeude;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mitarbeiter")
    private Mitarbeiter mitarbeiter;
}
