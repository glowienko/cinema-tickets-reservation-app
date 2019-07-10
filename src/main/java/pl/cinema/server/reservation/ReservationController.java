package pl.cinema.server.reservation;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.cinema.server.reservation.dto.ReservationCommand;
import pl.cinema.server.reservation.dto.ReservationConfirmationDto;

@RestController
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationHandler reservationHandler;

    @PostMapping("/reservations")
    ReservationConfirmationDto makeReservation(@RequestBody ReservationCommand command) {
        return reservationHandler.makeReservation(command);
    }
}
