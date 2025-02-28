package bg.softuni.bitchron.model.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Date;

public class DateNotInTheFutureValidator implements ConstraintValidator<DateNotInTheFuture, Date> {
    @Override
    public boolean isValid(Date date, ConstraintValidatorContext constraintValidatorContext) {
        Date now = new Date();

        return now.after(date);
    }
}
