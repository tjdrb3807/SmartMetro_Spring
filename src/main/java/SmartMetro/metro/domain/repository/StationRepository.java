package SmartMetro.metro.domain.repository;

import SmartMetro.metro.domain.Station;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StationRepository {

    private final EntityManager entityManager;

    public Station findOneStationById(Long id) {
        return entityManager.find(Station.class, id);
    }

    public Station findOneByStationCode(Integer stationCode) {
        return entityManager.find(Station.class, stationCode);
    }

    public List<Station> findAll() {
        return entityManager.createQuery("select s from Station s", Station.class)
                .getResultList();
    }

    public List<Station> findByStationCode(Integer stationCode) {
        return entityManager.createQuery("select s from Station s where s.stationCode = :stationCode", Station.class)
                .setParameter("stationCode", stationCode)
                .getResultList();
    }
}
