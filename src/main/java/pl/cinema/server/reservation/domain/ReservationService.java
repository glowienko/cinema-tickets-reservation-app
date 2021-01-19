package pl.cinema.server.reservation.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import pl.cinema.server.customer.domain.CustomerFacade;
import pl.cinema.server.customer.domain.CustomerMadeReservationEvent;
import pl.cinema.server.customer.domain.SavedCustomerDetails;
import pl.cinema.server.reservation.adapters.api.dto.ReservationMakerDto;
import pl.cinema.server.reservation.domain.exception.ReservationNotFoundException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class ReservationService {
    private final ReservationMaker reservationMaker;
    private final ReservationRepositoryPort reservationRepositoryPort;
    private final CustomerFacade customerFacade;

    @Transactional
    public Reservation makeReservation(ReservationMakerDto maker, List<SelectedSeat> selectedSeats, LocalDateTime screeningStartTime) {
        SavedCustomerDetails savedCustomerDetails = informAboutCustomerReservation(maker);
        Reservation newReservation = reservationMaker.makeReservation(selectedSeats, screeningStartTime, savedCustomerDetails);

        return reservationRepositoryPort.save(newReservation);
    }

    @Transactional
    public boolean confirmReservation(UUID reservationId) {
        Reservation reservation = reservationRepositoryPort.findByUuid(reservationId)
                .orElseThrow(ReservationNotFoundException::new);

        boolean result = reservation.confirm();
        reservationRepositoryPort.save(reservation);
        return result;
    }

    private SavedCustomerDetails informAboutCustomerReservation(ReservationMakerDto maker) {
        CustomerMadeReservationEvent customerMadeReservationEvent = CustomerMadeReservationEvent.builder()
                .birthDate(maker.getBirthDate())
                .name(maker.getName())
                .surname(maker.getSurname())
                .customerType(maker.getCustomerType())
                .voucherCode(maker.getVoucherCode())
                .build();
        return customerFacade.customerMadeReservation(customerMadeReservationEvent);
    }
}
