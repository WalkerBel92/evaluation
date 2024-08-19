package com.bbeltranl.evaluation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Value;

/**
 * Validator implementation for the {@link ValidPassword} annotation.
 * <p>
 * This class implements the {@link ConstraintValidator} interface to provide custom validation logic
 * for password values based on a specified pattern. The validator checks if the password value adheres to
 * the defined pattern to ensure it meets the required criteria.
 * </p>
 * <p>
 * The password pattern is injected from application properties and used to validate the password value.
 * </p>
 *
 * @author bbeltranl
 * @version 1.0
 * @since 2024-08-19
 */
public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {

    @Value("${custom.patterns.password}")
    private String passwordPattern;

    /**
     * Initializes the validator with the given annotation.
     * This method is called before any validation occurs to set up the validator.
     *
     * @param constraintAnnotation The annotation that specifies the constraints for the validation.
     *                             This parameter is the annotation instance that this validator is handling.
     */
    @Override
    public void initialize(ValidPassword constraintAnnotation) {
    }

    /**
     * Validates whether the given value meets the constraints defined by the custom annotation.
     *
     * @param value The value to be validated, typically a string in this case.
     * @param context The context in which the constraint is evaluated. It can be used to build a detailed
     *                error message if validation fails.
     * @return {@code true} if the value is valid according to the constraints; {@code false} otherwise.
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return value.matches(passwordPattern);
    }
}
