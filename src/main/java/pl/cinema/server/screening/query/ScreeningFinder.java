package pl.cinema.server.screening.query;

import lombok.RequiredArgsConstructor;
import pl.cinema.server.screening.query.dto.AvailableScreeningDto;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
class ScreeningFinder {
    private final ScreeningRepositoryPort screeningRepository;

    List<AvailableScreeningDto> findScreenings(LocalDateTime startTimeRange, LocalDateTime endTimeRange) {
        return screeningRepository.getAvailableScreenings(startTimeRange, endTimeRange)
                .stream()
                .map(Screening::toAvailableScreeningDto)
                .collect(toList());
    }
}
