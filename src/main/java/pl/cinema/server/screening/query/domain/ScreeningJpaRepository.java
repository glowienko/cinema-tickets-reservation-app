package pl.cinema.server.screening.query.domain;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

interface ScreeningJpaRepository extends JpaRepository<ScreeningReadEntity, Long> {

    List<ScreeningReadEntity> findAllByStartTimeAfterAndEndTimeBefore(LocalDateTime start, LocalDateTime end, Sort orders);
}
