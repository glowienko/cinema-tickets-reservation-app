package pl.cinema.server.screening.query;

import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
public class ScreeningRepository implements ScreeningRepositoryPort {
    private final ScreeningJpaRepository screeningJpaRepository;

    @Override
    public List<Screening> getAvailableScreenings(LocalDateTime start, LocalDateTime end) {
        return screeningJpaRepository.findAllByStartDateTimeAfterAndEndDateTimeBefore(start, end);
    }
}