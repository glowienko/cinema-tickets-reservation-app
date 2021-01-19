package pl.cinema.server.screening.query.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

interface ScreeningQueryRepositoryPort {

    List<ScreeningReadEntity> getAvailableScreenings(LocalDateTime start, LocalDateTime end);
    Optional<ScreeningReadEntity> getScreeningDetails(Long id);
}
