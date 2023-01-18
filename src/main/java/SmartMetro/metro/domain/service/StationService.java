package SmartMetro.metro.domain.service;

import SmartMetro.metro.domain.Station;
import SmartMetro.metro.domain.repository.StationRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StationService {
    private final StationRepository stationRepository;

    public Station findStation(Long id) {
        return stationRepository.findOneStationById(id);
    }

    public List<Station> findStations() {
        return stationRepository.findAll();
    }

    public List<Station> findStationByCode(Integer stationCode) {
        return stationRepository.findByStationCode(stationCode);
    }
}
