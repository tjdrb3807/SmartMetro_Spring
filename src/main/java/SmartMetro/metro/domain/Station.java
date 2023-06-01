package SmartMetro.metro.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "station_id")
    private Long id;

    private Integer stationCode;

    private String stationName;

    private String beforeStationName;

    private String afterStationName;

    private String stationLineCode;
}
