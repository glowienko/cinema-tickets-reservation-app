package pl.cinema.server.reservation.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "reservation.trashhold")
class BookingExpirationTrashhold {

    private Long minutes;
}
