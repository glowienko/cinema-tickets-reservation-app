package pl.cinema.server.screening.query.dto;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class AvailableScreeningDto {
    Long id;
    String movieTitle;
    LocalDateTime start;
    LocalDateTime end;
}
