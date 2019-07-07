package pl.cinema.server.screening.query;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ScreeningJpaRepository extends JpaRepository<Screening, Long> {

    List<Screening> findAllByStartDateTimeAfterAndEndDateTimeBefore(LocalDateTime start, LocalDateTime end);
}
