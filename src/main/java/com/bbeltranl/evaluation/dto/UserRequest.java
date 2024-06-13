package com.bbeltranl.evaluation.dto;

import com.bbeltranl.evaluation.model.Phone;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.List;

/**
 * The UserRequest class represents the data transfer object for user-related operations.
 * <p>
 * This class is used to encapsulate the information required to create or update a user.
 * It typically includes fields that are necessary for such operations and is often used
 * as a parameter in service and controller methods.
 * </p>
 *
 * @author bbeltranl
 * @version 1.0
 * @since 2024-06-13
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRequest {

    /**
     * The name of the user.
     */
    @NotBlank(message = "Nombre requerido")
    private String name;

    /**
     * The email address of the user.
     */
    @NotBlank(message = "Email requerido")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Formato de correo electrónico inválido")
    //@Email(message = "Formato de correo electrónico inválido")
    private String email;

    /**
     * The password of the user.
     */
    @NotBlank(message = "Password requerida")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$", message = "La contraseña debe contener al menos 8 caracteres, una letra mayúscula, una letra minúscula, un dígito y un carácter especial")
    private String password;

    /**
     * Phone list of the user.
     */
    private List<Phone> phones;
}
