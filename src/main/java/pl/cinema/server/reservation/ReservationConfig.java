package pl.cinema.server.reservation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ReservationConfig {

    @Bean
    ReservationHandler reservationHandler() {
        return new ReservationHandler();
    }
}
