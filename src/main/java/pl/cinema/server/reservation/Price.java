package pl.cinema.server.reservation;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.math.BigDecimal;

@Value
@AllArgsConstructor
class Price {
    BigDecimal value;
}
