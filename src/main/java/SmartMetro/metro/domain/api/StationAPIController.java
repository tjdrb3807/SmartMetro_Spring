package SmartMetro.metro.domain.api;

import SmartMetro.metro.domain.Station;
import SmartMetro.metro.domain.service.StationService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class StationAPIController {

    private final StationService stationService;

    @GetMapping("api/v2/stations/{stationCode}")
    public Result searchStationV2(@PathVariable("stationCode") Integer stationCode) {
        List<Station> findStations = stationService.findStationByCode(stationCode);
        List<StationDTO> collect = findStations.stream()
                .map(s -> new StationDTO(s.getStationName(), s.getStationLineNumber(), s.getBeforeStationName(), s.getAfterStationName()))
                .collect(Collectors.toList());

        return new Result(collect);
    }

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private T data;
    }

    @Data
    @AllArgsConstructor
    static class StationDTO {
        private String stationName;
        private Integer stationLineNumber;
        private String beforeStationName;
        private String afterStationName;
    }
}
