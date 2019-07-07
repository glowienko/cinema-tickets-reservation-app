package pl.cinema.server.screening.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;
import pl.cinema.server.screening.query.dto.AvailableScreeningDto;
import pl.cinema.server.screening.query.dto.ScreeningDetailDto;
import pl.cinema.server.screening.query.dto.ScreeningSeatDto;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Entity
@Getter
@Builder
@Immutable
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "screenings")
class ScreeningQuery {
    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    private LocalDateTime start;
    private LocalDateTime end;

    @OneToMany(mappedBy = "screening")
    private List<ScreeningSeat> seats;

    @ManyToOne(optional = false)
    @JoinTable(name = "room_id")
    private Room room;

    AvailableScreeningDto toAvailableScreeningDto() {
        return AvailableScreeningDto.builder()
                .id(this.id)
                .movieTitle(this.movie != null ? this.movie.getTitle() : null)
                .start(this.start)
                .end(this.end)
                .build();
    }

    ScreeningDetailDto toScreeningDetailDto() {
        return ScreeningDetailDto .builder()
                .id(this.id)
                .movieTitle(this.movie != null ? this.movie.getTitle() : null)
                .start(this.start)
                .end(this.end)
                .roomName(this.room != null ? this.room.getName() : null)
                .seats(toSeatsDto())
                .build();
    }

    private List<ScreeningSeatDto> toSeatsDto() {
        return this.seats.stream()
                .map(ScreeningSeat::toDto)
                .collect(toList());
    }
}
