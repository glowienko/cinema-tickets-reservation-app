package pl.cinema.server.screening.query.dto;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;

@Value
@Builder
public class ScreeningDetailDto {
    Long id;
    String movieTitle;
    LocalDateTime start;
    LocalDateTime end;
    String roomName;
    List<ScreeningSeatDto> seats;


}
