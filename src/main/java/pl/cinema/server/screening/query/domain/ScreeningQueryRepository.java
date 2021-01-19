package pl.cinema.server.screening.query.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
class ScreeningQueryRepository implements ScreeningQueryRepositoryPort {
    private final ScreeningJpaRepository screeningJpaRepository;

    public List<ScreeningReadEntity> getAvailableScreenings(LocalDateTime startTime, LocalDateTime endTime) {
        return screeningJpaRepository.findAllByStartTimeAfterAndEndTimeBefore(startTime, endTime, Sort.by(Direction.DESC, "movieTitle", "startTime"));
    }

    public Optional<ScreeningReadEntity> getScreeningDetails(Long id) {
        return screeningJpaRepository.findById(id);
    }

}