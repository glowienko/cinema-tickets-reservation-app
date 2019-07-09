package pl.cinema.server.reservation.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;

class NotTooLateForBookingValidator implements ConstraintValidator<NotTooLateForBooking, LocalDateTime> {
    @Override
    public boolean isValid(LocalDateTime screeningStart, ConstraintValidatorContext context) {
        LocalDateTime bookingTime = LocalDateTime.now();
        LocalDateTime maxBookingTime = screeningStart.minusMinutes(15);

        return bookingTime.isBefore(maxBookingTime) || bookingTime.equals(maxBookingTime);
    }
}
