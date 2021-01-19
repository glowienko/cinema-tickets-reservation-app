package pl.cinema.server.reservation.domain;

import java.util.UUID;

public interface ReservationLinkGenerator {

    String generateConfirmationLink(UUID reservationId);
}
