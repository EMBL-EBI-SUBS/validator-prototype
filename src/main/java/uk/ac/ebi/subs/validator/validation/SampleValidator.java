package uk.ac.ebi.subs.validator.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class SampleValidator implements Validator {
    private static final Logger logger = LoggerFactory.getLogger(SampleValidator.class);

    @Override
    public boolean supports(Class<?> clazz) {
        return SampleValidator.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        // TODO
    }

    /* An example:
     * public class UserLoginValidator implements SampleValidator {
     *
     *    private static final int MINIMUM_PASSWORD_LENGTH = 6;
     *
     *    public boolean supports(Class clazz) {
     *       return UserLogin.class.isAssignableFrom(clazz);
     *    }
     *
     *    public void validate(Object target, Errors errors) {
     *       ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "field.required");
     *       ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "field.required");
     *       UserLogin login = (UserLogin) target;
     *       if (login.getPassword() != null
     *             && login.getPassword().trim().length() < MINIMUM_PASSWORD_LENGTH) {
     *          errors.rejectValue("password", "field.min.length",
     *                new Object[]{Integer.valueOf(MINIMUM_PASSWORD_LENGTH)},
     *                "The password must be at least [" + MINIMUM_PASSWORD_LENGTH + "] characters in length.");
     *       }
     *    }
     * }
     * */
}
