package pl.cinema.server.reservation.adapters.api;

import org.springframework.stereotype.Component;
import pl.cinema.server.reservation.domain.ReservationLinkGenerator;

import java.util.UUID;

@Component
class ConfirmReservationLinkGenerator implements ReservationLinkGenerator {  //TODO: here for sure?

    @Override
    public String generateConfirmationLink(UUID reservationId) {
        return "http://localhost:9999/reservations/" + reservationId + "/confirm";
    }
}
