package pl.cinema.server.reservation.domain;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(BookingExpirationTrashhold.class)
class ReservationConfig {
}
