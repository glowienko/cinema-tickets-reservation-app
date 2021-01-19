package pl.cinema.server.reservation.adapters.api.dto;

import lombok.Builder;
import lombok.Value;
import pl.cinema.server.customer.domain.CustomerType;
import pl.cinema.server.reservation.adapters.api.validation.PersonName;
import pl.cinema.server.reservation.adapters.api.validation.Surname;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Value
@Builder
public class ReservationMakerDto {
    @NotBlank
    @PersonName
    String name;

    @Surname
    @NotBlank
    String surname;

    @NotNull
    LocalDate birthDate;

    CustomerType customerType;

    String voucherCode;
}
