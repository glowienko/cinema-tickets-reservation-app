package pl.cinema.server.reservation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;

import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.LocalDateTime.now;

@Component
@RequiredArgsConstructor
public class WeekendPriceEvaluator implements PriceEvaluator {
    private static final List<DayOfWeek> weekendDays = List.of(FRIDAY, SATURDAY, SUNDAY);
    private static final BigDecimal CURRENT_WEEKEND_CHARGE = BigDecimal.valueOf(4);
    private final WeekendTicketsProperty ticketsProperty;

    @Override
    public Price evaluatePrice(String voucherCode) {
        return new Price(CURRENT_WEEKEND_CHARGE);
    }

    @Override
    public boolean canHandle(Long customerId) {
        LocalDateTime now = now();  // should be used now(Clock), clock in global config autowired to this class
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        int nowHour = now.getHour();

        boolean isWeekend = weekendDays.contains(dayOfWeek);

        if (!isWeekend) {
            return false;
        }

        if (dayOfWeek.equals(FRIDAY) && nowHour > ticketsProperty.getWeekendStartHour()) {
            return true;
        }

        if (dayOfWeek.equals(SUNDAY) && nowHour < ticketsProperty.getWeekendEndHour()) {
            return true;
        }

        return true;
    }
}
