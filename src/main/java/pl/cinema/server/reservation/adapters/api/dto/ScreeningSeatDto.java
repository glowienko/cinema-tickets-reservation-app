package pl.cinema.server.reservation.adapters.api.dto;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Value;
import pl.cinema.server.reservation.domain.SelectedSeat;
import pl.cinema.server.screening.query.domain.SeatStatus;

import javax.validation.constraints.Min;

@Value
@Builder
public class ScreeningSeatDto {
    @NotNull
    Long id;

    @NotNull
    Long row;

    @NotNull
    @Min(value = 1)
    Long number;

    @NotNull
    SeatStatus status;


    public SelectedSeat toSelectedSeat() {
        return new SelectedSeat(id, status);
    }
}
