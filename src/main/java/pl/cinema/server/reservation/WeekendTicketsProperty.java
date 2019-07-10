package pl.cinema.server.reservation;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "tickes")
class WeekendTicketsProperty {

    @NotNull
    private BigDecimal weekendExtraCost;

    @NotNull
    private Integer weekendStartHour;

    @NotNull
    private Integer weekendEndHour;


}
