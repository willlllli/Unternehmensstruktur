package unternehmensstruktur.model.db;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "it_asset")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItAsset {

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
}
