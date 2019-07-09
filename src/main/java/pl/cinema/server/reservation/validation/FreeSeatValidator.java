package pl.cinema.server.reservation.validation;

import pl.cinema.server.screening.SeatStatus;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

class FreeSeatValidator implements ConstraintValidator<FreeSeat, SeatStatus> {
    @Override
    public boolean isValid(SeatStatus value, ConstraintValidatorContext context) {
        return value.equals(SeatStatus.FREE);
    }
}
