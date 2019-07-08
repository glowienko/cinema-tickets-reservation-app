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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static javax.persistence.FetchType.LAZY;

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
    private LocalDateTime start;
    private LocalDateTime end;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne(optional = false, fetch = LAZY)
    @JoinTable(name = "room_id")
    private RoomQuery room; // todo: room is not fetched correctly

    @OneToMany(mappedBy = "screening", orphanRemoval = true, fetch = LAZY)
    private List<ScreeningSeatQuery> seats;


    AvailableScreeningDto toAvailableScreeningDto() {
        return AvailableScreeningDto.builder()
                .id(id)
                .movieTitle(movie != null ? movie.getTitle() : null)
                .start(start)
                .end(end)
                .build();
    }

    ScreeningDetailDto toScreeningDetailDto() {
        return ScreeningDetailDto.builder()
                .id(id)
                .movieTitle(movie != null ? movie.getTitle() : null)
                .start(start)
                .end(end)
                .roomName(room != null ? room.getName() : null)
                .seats(toSeatsDto())
                .build();
    }

    private List<ScreeningSeatDto> toSeatsDto() {
        return this.seats.stream()
                .map(ScreeningSeatQuery::toDto)
                .collect(toList());
    }
}
