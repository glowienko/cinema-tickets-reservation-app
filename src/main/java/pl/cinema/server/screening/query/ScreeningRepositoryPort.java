package pl.cinema.server.screening.query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ScreeningRepositoryPort {

    List<ScreeningQuery> getAvailableScreenings(LocalDateTime start, LocalDateTime end);
    Optional<ScreeningQuery> getScreeningDetails(Long id);
}
