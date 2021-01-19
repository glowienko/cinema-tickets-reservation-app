package pl.cinema.server.screening.query.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ScreeningFinder {
    private final ScreeningQueryRepositoryPort screeningRepository;

    public List<ScreeningReadEntity> findScreenings(LocalDateTime startTimeRange, LocalDateTime endTimeRange) {
        return screeningRepository.getAvailableScreenings(startTimeRange, endTimeRange);

    }

    public ScreeningReadEntity getScreeningDetails(Long id) {
        return screeningRepository
                .getScreeningDetails(id)
                .orElseThrow(()-> new IllegalStateException("Cannot find screening detail by id: " + id));
    }
}
