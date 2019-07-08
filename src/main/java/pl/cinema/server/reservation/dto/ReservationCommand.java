package pl.cinema.server.reservation.dto;


import lombok.Builder;
import lombok.Value;
import pl.cinema.server.screening.query.dto.ScreeningSeatDto;

import java.time.LocalDateTime;
import java.util.List;

@Value
@Builder
public class ReservationCommand {
    Long screeningId;

    //validacja na screening -> czy now złożenia zlecenia jest 15 minut przed start time
    LocalDateTime screeningStartTime;

    MakerDto maker;
    List<ScreeningSeatDto> selectedSeats;

}

