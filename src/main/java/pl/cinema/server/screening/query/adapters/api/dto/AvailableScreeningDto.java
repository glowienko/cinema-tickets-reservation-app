package pl.cinema.server.screening.query.adapters.api.dto;

import lombok.Builder;
import lombok.Value;
import pl.cinema.server.screening.query.domain.ScreeningReadEntity;

import java.time.LocalDateTime;

@Value
@Builder
public class AvailableScreeningDto {
    Long id;
    String movieTitle;
    LocalDateTime start;
    LocalDateTime end;

    public static AvailableScreeningDto valueOf(ScreeningReadEntity input) {
        return AvailableScreeningDto.builder()
                .id(input.getId())
                .movieTitle(input.getMovieTitle())
                .start(input.getStartTime())
                .end(input.getEndTime())
                .build();
    }
}
