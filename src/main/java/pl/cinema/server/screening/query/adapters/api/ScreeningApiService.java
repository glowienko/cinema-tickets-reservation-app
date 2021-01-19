package pl.cinema.server.screening.query.adapters.api;

import pl.cinema.server.screening.query.adapters.api.dto.AvailableScreeningDto;
import pl.cinema.server.screening.query.adapters.api.dto.ScreeningDetailDto;
import pl.cinema.server.screening.query.domain.ScreeningFinder;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.stream.Collectors.toList;

class ScreeningApiService {
    private final ScreeningFinder screeningFinder;

    public ScreeningApiService(ScreeningFinder screeningFinder) {
        this.screeningFinder = screeningFinder;
    }


    List<AvailableScreeningDto> findScreenings(LocalDateTime startTimeRange, LocalDateTime endTimeRange) {
        return screeningFinder.findScreenings(startTimeRange, endTimeRange)
                .stream()
                .map(AvailableScreeningDto::valueOf)
                .collect(toList());
    }

    ScreeningDetailDto getScreeningDetails(Long id) {
        return ScreeningDetailDto.valueOf(screeningFinder.getScreeningDetails(id));



    }
}
