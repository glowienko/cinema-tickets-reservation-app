package pl.cinema.server.screening.query;

import lombok.RequiredArgsConstructor;
import pl.cinema.server.screening.query.dto.AvailableScreeningDto;
import pl.cinema.server.screening.query.dto.ScreeningDetailDto;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
class ScreeningFinder {
    private final ScreeningRepositoryPort screeningRepository;

    List<AvailableScreeningDto> findScreenings(LocalDateTime startTimeRange, LocalDateTime endTimeRange) {
        return screeningRepository.getAvailableScreenings(startTimeRange, endTimeRange)
                .stream()
                .map(ScreeningQuery::toAvailableScreeningDto)
                .collect(toList());
    }

    ScreeningDetailDto getScreeningDetails(Long id) {
        return screeningRepository
                .getScreeningDetails(id)
                .map(ScreeningQuery::toScreeningDetailDto)
                .orElseThrow(()-> new IllegalStateException("Cannot find screening detail by id: " + id));
    }
}
