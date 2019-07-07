package pl.cinema.server.screening.query;

import java.time.LocalDateTime;
import java.util.List;

public interface ScreeningRepositoryPort {

    List<Screening> getAvailableScreenings(LocalDateTime start, LocalDateTime end);
}
