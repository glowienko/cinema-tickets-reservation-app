package pl.cinema.server.screening.query

import java.time.LocalDateTime

class InMemoryScreeningRepository implements ScreeningRepositoryPort {
    List<Screening> entities = []

    @Override
    List<Screening> getAvailableScreenings(LocalDateTime start, LocalDateTime end) {
        entities.findAll { e -> e.getStartDateTime().isAfter(start) }
                .findAll { e -> e.getEndDateTime().isBefore(end) }
    }
}
