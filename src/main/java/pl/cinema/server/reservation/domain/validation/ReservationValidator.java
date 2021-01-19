package pl.cinema.server.reservation.domain.validation;

import org.springframework.stereotype.Component;
import pl.cinema.server.reservation.domain.Reservation;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

@Component
public class ReservationValidator {

    private static final Validator VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();

    boolean validate(Reservation reservation) {
        Set<ConstraintViolation<Reservation>> result = VALIDATOR.validate(reservation);

       return result.isEmpty();

    }
}
