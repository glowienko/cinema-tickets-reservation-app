package pl.cinema.server.reservation;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.cinema.server.customer.CustomerFacade;

import java.util.List;

@Configuration
@EnableConfigurationProperties(WeekendTicketsProperty.class)
class ReservationConfig {

    @Bean
    ReservationHandler reservationHandler(List<PriceEvaluator> evaluators, CustomerFacade facade) {
        return new ReservationHandler(evaluators, facade);
    }
}
