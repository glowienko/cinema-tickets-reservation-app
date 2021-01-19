package pl.cinema.server.reservation.adapters.api;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.cinema.server.reservation.adapters.api.dto.ReservationCommand;
import pl.cinema.server.reservation.adapters.api.dto.ReservationConfirmationDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
class ReservationController {
    private final ReservationApiService reservationApiService;

    @PostMapping
    ReservationConfirmationDto makeReservation(@RequestBody @Valid ReservationCommand command) {
        return reservationApiService.makeReservation(command);
    }

    @PostMapping("/{reservationId}/confirm")
    ResponseEntity<Void> confirmReservation(@PathVariable @NotNull UUID reservationId) {
        if (reservationApiService.confirmReservation(reservationId)) {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }

}
