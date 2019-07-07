package pl.cinema.server.screening.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;
import pl.cinema.server.screening.query.dto.AvailableScreeningDto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@Immutable
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "screenings")
class Screening {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    AvailableScreeningDto toAvailableScreeningDto() {
        return AvailableScreeningDto.builder()
                .id(this.id)
                .movieTitle(this.movie != null ? this.movie.getName() : null)
                .startDateTime(this.startDateTime)
                .endDateTime(this.endDateTime)
                .build();
    }
}
