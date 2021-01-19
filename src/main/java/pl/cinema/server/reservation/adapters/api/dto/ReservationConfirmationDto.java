package pl.cinema.server.reservation.adapters.api.dto;

import lombok.Value;
import pl.cinema.server.reservation.domain.Reservation;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Value
public class ReservationConfirmationDto {
    BigDecimal totalPriceToPay;
    LocalDateTime expirationDateTime;
    String confirmationLink;


    public static ReservationConfirmationDto valueOf(Reservation reservation) {
        return new ReservationConfirmationDto(
                reservation.getAmount(),
                reservation.getExpirationTime(),
                reservation.getConfirmationLink());
    }
}
