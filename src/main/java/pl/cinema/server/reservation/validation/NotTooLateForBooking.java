package pl.cinema.server.reservation.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = NotTooLateForBookingValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NotTooLateForBooking {
    String message() default "Rezerwacja musi być wykonana przynajmniej 15 minut przed seansem.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
