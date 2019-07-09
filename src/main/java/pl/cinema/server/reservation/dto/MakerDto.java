package pl.cinema.server.reservation.dto;

import lombok.Builder;
import lombok.Value;
import pl.cinema.server.reservation.validation.PersonName;
import pl.cinema.server.reservation.validation.Surname;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Value
@Builder
public class MakerDto {
    @NotBlank
    @PersonName
    String name;

    @NotBlank
    @Surname
    String surname;

    @NotNull
    Long age;

    String voucherCode;
}
