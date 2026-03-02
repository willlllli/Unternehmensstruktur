package unternehmensstruktur.model.db;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name = "projekt")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Projekt {

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

    @Column(name = "deadline")
    private LocalDate deadline;

    @Column(name = "fortschritt")
    private Integer fortschritt;
}
