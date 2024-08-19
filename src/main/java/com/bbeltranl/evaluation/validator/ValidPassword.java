package com.bbeltranl.evaluation.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom annotation for validating password values.
 * <p>
 * This annotation is used to enforce that a password meets specific criteria defined by a pattern.
 * It is applied to fields or parameters where password validation is required. The validation logic
 * is implemented by the {@link PasswordValidator} class.
 * </p>
 * <p>
 * The default error message can be customized by providing a different value for the {@code message}
 * attribute when using this annotation.
 * </p>
 *
 * @author bbeltranl
 * @version 1.0
 * @since 2024-08-19
 */
@Constraint(validatedBy = PasswordValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPassword {

    String message() default "Ingrese una contraseña que cumpla con el patrón requerido.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
