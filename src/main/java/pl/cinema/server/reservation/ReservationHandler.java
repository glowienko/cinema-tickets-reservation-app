package pl.cinema.server.reservation;


import lombok.RequiredArgsConstructor;
import pl.cinema.server.reservation.dto.ReservationCommand;
import pl.cinema.server.reservation.dto.ReservationConfirmationDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RequiredArgsConstructor
class ReservationHandler {

    ReservationConfirmationDto makeReservation(ReservationCommand reservationCommand) {
        return new ReservationConfirmationDto(BigDecimal.valueOf(100), LocalDateTime.now());
    }
}
