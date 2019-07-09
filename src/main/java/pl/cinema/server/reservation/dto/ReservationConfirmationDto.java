package pl.cinema.server.reservation.dto;

import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Value
public class ReservationConfirmationDto {
    BigDecimal totalPriceToPay;
    LocalDateTime expirationDateTime;
}
