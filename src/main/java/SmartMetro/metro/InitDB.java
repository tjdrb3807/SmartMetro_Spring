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
            Station station = createStation(225, "방배", "서초", "사당", "0225");
            Station station1 = createStation(226, "사당", "방배", "낙성대", "0226,0433");
            Station station3 = createStation(433, "사당", "총신대입구(이수)", "남태령", "0226,0433");
            Station station2 = createStation(227, "낙성대","서울대입구", "사당", "0227");
            Station station4 = createStation(432, "총신대입구(이수)", "동작(현충원)", "사당", "0432,0738");
            Station station5 = createStation(738, "총신대입구", "내방", "남성", "0432,0738");

            entityManager.persist(station);
            entityManager.persist(station1);
            entityManager.persist(station2);
            entityManager.persist(station3);
            entityManager.persist(station4);
            entityManager.persist(station5);
        }

        private Station createStation(Integer stationCode, String stationName, String beforeStationName, String afterStationName, String stationLineCode) {
            Station station = new Station();
            station.setStationCode(stationCode);
            station.setStationName(stationName);
            station.setBeforeStationName(beforeStationName);
            station.setAfterStationName(afterStationName);
            station.setStationLineCode(stationLineCode);

            return station;
        }
    }
}
