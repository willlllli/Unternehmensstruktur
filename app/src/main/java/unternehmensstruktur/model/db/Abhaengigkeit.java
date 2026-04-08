package unternehmensstruktur.model.db;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "abhaengigkeit")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Abhaengigkeit {

    @EmbeddedId
    private AbhaengigkeitId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("upstreamItAsset")
    @JoinColumn(name = "upstream_it_asset")
    private ItAsset upstreamItAsset;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("downstreamItAsset")
    @JoinColumn(name = "downstream_it_asset")
    private ItAsset downstreamItAsset;
}
