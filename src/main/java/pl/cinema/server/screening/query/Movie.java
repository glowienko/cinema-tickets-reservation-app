package pl.cinema.server.screening.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;
import org.springframework.boot.convert.DurationUnit;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Immutable
@Table(name = "movies")
class Movie {
    @Id
    private Long id;
    @DurationUnit(value = ChronoUnit.MINUTES)
    private Duration length;
    private String title;
}
