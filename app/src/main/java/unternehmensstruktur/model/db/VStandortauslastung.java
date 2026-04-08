package unternehmensstruktur.model.db;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Immutable;

import java.math.BigDecimal;

@Entity
@Immutable
@Table(name = "v_standortauslastung", schema = "unternehmensstruktur")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VStandortauslastung {

    @EmbeddedId
    private VStandortauslastungId id;

    @Column(name = "buchungen")
    private Long buchungen;

    @Column(name = "gesamt_arbeitsplaetze")
    private Long gesamtArbeitsplaetze;

    @Column(name = "auslastung_prozent")
    private BigDecimal auslastungProzent;

    @Column(name = "auslastungsklasse")
    private String auslastungsklasse;
}
