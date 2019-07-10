package pl.cinema.server.screening.query;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import pl.cinema.server.cinema.Seat;
import pl.cinema.server.screening.SeatStatus;
import pl.cinema.server.screening.query.dto.ScreeningSeatDto;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import static javax.persistence.EnumType.STRING;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "screening_seats")
class ScreeningSeatQuery {

    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name = "seat_id")
    private Seat seat;

    @Enumerated(STRING)
    private SeatStatus status;

    @ManyToOne
    @JoinColumn(name = "screening_id")
    private ScreeningQuery screening;

    ScreeningSeatDto toDto() {
        return ScreeningSeatDto.builder()
                .id(this.id)
                .number(this.seat != null ? this.seat.getNumber() : null)
                .row(this.seat != null ? this.seat.getRow() : null)
                .status(this.status).build();
    }
}
