package unternehmensstruktur.model.db;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

// Note: Class named ItSystem to avoid conflict with java.lang.System
@Entity
@Table(name = "system")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItSystem {

    @Id
    @Column(name = "icto_nummer")
    private String ictoNummer;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "risikostufe")
    private Integer risikostufe;

    @Column(name = "budget")
    private Integer budget;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organisationseinheit", nullable = false)
    private Organisationseinheit organisationseinheit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kunde", nullable = false)
    private Kunde kunde;

    @Column(name = "end_of_life_datum")
    private LocalDate endOfLifeDatum;
}
