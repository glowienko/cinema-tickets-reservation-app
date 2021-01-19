package pl.cinema.server.reservation.domain;

import lombok.Value;
import pl.cinema.server.screening.query.domain.SeatStatus;

@Value
public class SelectedSeat {
    Long id;
    SeatStatus status;
    Long row;
    Long number;
}
