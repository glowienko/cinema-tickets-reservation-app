package pl.cinema.server.reservation.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.cinema.server.customer.domain.SavedCustomerDetails;
import pl.cinema.server.reservation.domain.exception.TooLateForReservationException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
class ReservationMaker { //moze bardziej reservation factory?
    private final ReservationLinkGenerator linkGenerator;
    private final BookingExpirationTrashhold expirationTrashhold;

    Reservation makeReservation(List<SelectedSeat> selectedSeats, LocalDateTime screeningStartTime, SavedCustomerDetails savedCustomerDetails) {
        if (LocalDateTime.now().plusMinutes(expirationTrashhold.getMinutes()).isAfter(screeningStartTime)) {
            throw new TooLateForReservationException();
        }

        UUID reservationId = UUID.randomUUID();
        String confirmationLink = linkGenerator.generateConfirmationLink(reservationId);
        Reservation newReservation = new Reservation(reservationId, confirmationLink, savedCustomerDetails.getUuid());

        newReservation.make(selectedSeats, savedCustomerDetails.getBirthDate(), savedCustomerDetails.getCustomerType());
        return newReservation;
    }
}
