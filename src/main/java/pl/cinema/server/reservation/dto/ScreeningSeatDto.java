package pl.cinema.server.reservation.dto;

import lombok.Builder;
import lombok.Value;
import pl.cinema.server.reservation.validation.FreeSeat;
import pl.cinema.server.screening.SeatStatus;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Value
@Builder
public class ScreeningSeatDto {
    @NotNull
    Long id;

    @Min(value = 1)
    @NotNull
    Long row;

    @NotNull
    @Min(value = 1)
    Long number;

    @NotNull
    @FreeSeat
    SeatStatus status;
}
