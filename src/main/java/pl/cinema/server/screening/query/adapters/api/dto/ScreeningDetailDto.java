package pl.cinema.server.screening.query.adapters.api.dto;

import lombok.Builder;
import lombok.Value;
import pl.cinema.server.screening.query.domain.ScreeningReadEntity;
import pl.cinema.server.screening.query.domain.ScreeningSeatReadEntity;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Value
@Builder
public class ScreeningDetailDto {
    Long id;
    String movieTitle;
    LocalDateTime start;
    LocalDateTime end;
    String roomName;
    List<ScreeningSeatDto> seats;

    public static ScreeningDetailDto valueOf(ScreeningReadEntity input) {
        return ScreeningDetailDto.builder()
                .id(input.getId())
                .movieTitle(input.getMovieTitle())
                .start(input.getStartTime())
                .end(input.getEndTime())
                .roomName(input.getRoomName())
                .seats(toSeatsDto(input.getSeats()))
                .build();
    }

    private static List<ScreeningSeatDto> toSeatsDto(List<ScreeningSeatReadEntity> seats) {
        return seats.stream()
                .map(ScreeningDetailDto::createSeatFrom)
                .collect(toList());
    }

    private static ScreeningSeatDto createSeatFrom(ScreeningSeatReadEntity input) {
        return ScreeningSeatDto.builder()
                .id(input.getId())
                .number(input.getNumber())
                .row(input.getRow())
                .status(input.getStatus().name()).build();
    }
}
