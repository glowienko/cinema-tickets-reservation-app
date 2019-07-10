package pl.cinema.server.reservation.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = FreeSeatValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FreeSeat {
    String message() default "Nie można zarezerować zajętego miejsca";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
