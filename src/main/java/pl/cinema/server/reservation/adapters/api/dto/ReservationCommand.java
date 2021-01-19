package pl.cinema.server.reservation.adapters.api.dto;


import lombok.Builder;
import lombok.Value;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Value
@Builder
public class ReservationCommand {
    @NotNull
    LocalDateTime screeningStartTime;

    @Valid
    @NotNull
    ReservationMakerDto maker;

    @Valid
    @NotEmpty
    List<ScreeningSeatDto> selectedSeats;

}

