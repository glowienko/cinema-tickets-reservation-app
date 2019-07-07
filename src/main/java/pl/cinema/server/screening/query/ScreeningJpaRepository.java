package pl.cinema.server.screening.query;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

interface ScreeningJpaRepository extends JpaRepository<ScreeningQuery, Long> {

    List<ScreeningQuery> findAllByStartAfterAndEndBefore(LocalDateTime start, LocalDateTime end, Sort orders);
//    List<ScreeningQuery> findAllByStartAfterAndEndBeforeOrderByMovieTitleDescStartDesc(LocalDateTime start, LocalDateTime end, Sort orders);
}
