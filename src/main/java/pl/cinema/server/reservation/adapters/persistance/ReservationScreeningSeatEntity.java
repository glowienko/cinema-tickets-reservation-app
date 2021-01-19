package pl.cinema.server.reservation.adapters.persistance;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.cinema.server.reservation.domain.SelectedSeat;
import pl.cinema.server.screening.query.domain.SeatStatus;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.EnumType.STRING;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "screening_seats")
class ReservationScreeningSeatEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(STRING)
    private SeatStatus status;

    private Long row;
    private Long number;

    static ReservationScreeningSeatEntity valueOf(SelectedSeat seat) {
        return new ReservationScreeningSeatEntity(seat.getId(), seat.getStatus(), seat.getRow(), seat.getNumber());
    }

    SelectedSeat toSeat() {
        return new SelectedSeat(id, status, row, number);
    }
}
