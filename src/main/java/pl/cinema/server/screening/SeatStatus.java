package pl.cinema.server.screening;


import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum SeatStatus {
    FREE("FREE"),
    TAKEN("TAKEN");

    private final String status;

    @JsonCreator
    SeatStatus fromStatus(String status) {
        return Arrays.stream(values())
                .filter(v -> v.getStatus().equals(status))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
