package unternehmensstruktur.model.db;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AbhaengigkeitId implements Serializable {

    @Column(name = "upstream_it_asset")
    private String upstreamItAsset;

    @Column(name = "downstream_it_asset")
    private String downstreamItAsset;
}
