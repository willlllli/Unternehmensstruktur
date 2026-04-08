package unternehmensstruktur.model.db;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name = "mitarbeiter")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mitarbeiter {

    @Id
    @Column(name = "personalnummer")
    private Integer personalnummer;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "a_kennung", unique = true)
    private String aKennung;

    @Column(name = "geburtsdatum", nullable = false)
    private LocalDate geburtsdatum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "privatadresse_id")
    private Adresse privatadresse;

    @Column(name = "email_geschaeftlich", unique = true)
    private String emailGeschaeftlich;

    @Column(name = "email_privat", unique = true)
    private String emailPrivat;

    @Column(name = "mobilnummer_geschaeftlich", unique = true)
    private String mobilnummerGeschaeftlich;

    @Column(name = "mobilnummer_privat", unique = true)
    private String mobilnummerPrivat;

    // Stored as plain FK to break circular dependency with Standort
    @Column(name = "standort_id")
    private Integer standortId;
}
