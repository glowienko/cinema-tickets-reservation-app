package pl.cinema.server.reservation;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
enum TicketType {
    CHILD("CHILD", 12.5),
    STUDENT("STUDENT", 18),
    ADULT("ADULT", 25);

    private final String type;
    private final double price; //may require BigDecimal, but double should be fine here

    @JsonCreator
    TicketType fromType(String type) {
        return Arrays.stream(values())
                .filter(v -> v.getType().equals(type))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
