package SmartMetro.metro;

import SmartMetro.metro.domain.Station;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class InitDB {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInit();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {
        private final EntityManager entityManager;

        public void dbInit() {
            Station station = createStation(0225, "방배", 2, "사당", "서초");
            Station station1 = createStation(0226, "사당", 2,"낙성대", "방배");

            entityManager.persist(station);
            entityManager.persist(station1);
        }

        private Station createStation(Integer stationCode, String stationName, Integer stationLineNumber, String beforeStationName, String afterStationName) {
            Station station = new Station();
            station.setStationCode(stationCode);
            station.setStationName(stationName);
            station.setStationLineNumber(stationLineNumber);
            station.setBeforeStationName(beforeStationName);
            station.setAfterStationName(afterStationName);

            return station;
        }
    }
}
