package unternehmensstruktur.model.db;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "mitglied")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mitglied {

    @EmbeddedId
    private MitgliedId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("mitarbeiter")
    @JoinColumn(name = "mitarbeiter")
    private Mitarbeiter mitarbeiter;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("organisationseinheit")
    @JoinColumn(name = "organisationseinheit")
    private Organisationseinheit organisationseinheit;
}
