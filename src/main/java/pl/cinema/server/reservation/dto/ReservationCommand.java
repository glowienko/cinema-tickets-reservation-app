package pl.cinema.server.reservation.dto;


import lombok.Builder;
import lombok.Value;
import pl.cinema.server.reservation.validation.NotTooLateForBooking;
import pl.cinema.server.screening.query.dto.ScreeningSeatDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Value
@Builder
public class ReservationCommand {
    @NotNull
    Long screeningId;

    //validacja na screening -> czy now złożenia zlecenia jest 15 minut przed start time
    @NotTooLateForBooking
    LocalDateTime screeningStartTime;

    @Valid
    @NotNull
    MakerDto maker;

    @Valid
    @Size(min = 1)
    @NotNull
    List<ScreeningSeatDto> selectedSeats;

}

