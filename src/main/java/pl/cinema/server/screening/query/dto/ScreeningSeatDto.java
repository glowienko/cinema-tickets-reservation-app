package pl.cinema.server.screening.query.dto;

import lombok.Builder;
import lombok.Value;
import pl.cinema.server.screening.SeatStatus;

@Value
@Builder
public class ScreeningSeatDto {
    Long id;
    Long row;
    Long number;
    SeatStatus status;
}
