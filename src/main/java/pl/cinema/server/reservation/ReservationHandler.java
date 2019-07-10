package pl.cinema.server.reservation;


import lombok.RequiredArgsConstructor;
import pl.cinema.server.customer.CustomerFacade;
import pl.cinema.server.customer.dto.CustomerDto;
import pl.cinema.server.reservation.dto.ReservationCommand;
import pl.cinema.server.reservation.dto.ReservationConfirmationDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
class ReservationHandler {
    private static final int BOOKING_EXPIRATION_TRASHHOLD_MINUTES = 15;
    private final List<PriceEvaluator> evaluators;
    private final CustomerFacade customerFacade;

    ReservationConfirmationDto makeReservation(ReservationCommand reservationCommand) {
        Long customerId = customerFacade.createIfNotExists(CustomerDto.builder().build()); //todo: finissh me
        String voucherCode = reservationCommand.getMaker().getVoucherCode();

        BigDecimal totalPrice = evaluators.stream()
                .filter(evaluator -> evaluator.canHandle(customerId))
                .map(evaluator -> evaluator.evaluatePrice(voucherCode))
                .map(Price::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return new ReservationConfirmationDto(totalPrice, calculateBookingExpTime(reservationCommand));
    }

    private LocalDateTime calculateBookingExpTime(ReservationCommand reservationCommand) {
        LocalDateTime screeningStartTime = reservationCommand.getScreeningStartTime();
        return screeningStartTime.minusMinutes(BOOKING_EXPIRATION_TRASHHOLD_MINUTES);
    }
}
