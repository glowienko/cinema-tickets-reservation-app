package pl.cinema.server.reservation.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class PersonNameValidator implements ConstraintValidator<Surname, String> {
    private static final Pattern NAME_PATTERN = Pattern.compile("[A-Z][a-z]*");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Matcher simpleMatcher = NAME_PATTERN.matcher(value);

        return simpleMatcher.matches();
    }
}
