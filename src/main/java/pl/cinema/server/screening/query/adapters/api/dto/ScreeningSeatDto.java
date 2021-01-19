package pl.cinema.server.screening.query.adapters.api.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ScreeningSeatDto {
    Long id;
    Long row;
    Long number;
    String status;
}
