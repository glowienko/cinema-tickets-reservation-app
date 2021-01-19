package pl.cinema.server.reservation.adapters.api.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = PersonNameValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PersonName {
    String message() default "Imię powinno zaczynać się z wielkiej litery i składać się wyłącznie z liter.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
