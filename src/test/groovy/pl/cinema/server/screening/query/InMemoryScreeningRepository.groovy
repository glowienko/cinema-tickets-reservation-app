package pl.cinema.server.screening.query

import java.time.LocalDateTime

class InMemoryScreeningRepository implements ScreeningRepositoryPort {
    List<ScreeningQuery> entities = []

    @Override
    List<ScreeningQuery> getAvailableScreenings(LocalDateTime start, LocalDateTime end) {
        entities.findAll { e -> e.getStart().isAfter(start) }
                .findAll { e -> e.getEnd().isBefore(end) }
    }

    @Override
    Optional<ScreeningQuery> getScreeningDetails(Long id) {
        return null
    }
}
