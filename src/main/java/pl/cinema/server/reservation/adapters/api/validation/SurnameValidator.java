package pl.cinema.server.reservation.adapters.api.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class SurnameValidator implements ConstraintValidator<Surname, String> {
    private static final Pattern SURNAME_PATTERN = Pattern.compile("[A-Z][a-z]*");
    private static final Pattern TWO_PART_SURNAME_PATTERN = Pattern.compile("[A-Z][a-z]*[-][A-Z][a-z]*");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Matcher simpleMatcher = SURNAME_PATTERN.matcher(value);
        Matcher complexSurnameMatcher = TWO_PART_SURNAME_PATTERN.matcher(value);

        return simpleMatcher.matches() || complexSurnameMatcher.matches();
    }
}
