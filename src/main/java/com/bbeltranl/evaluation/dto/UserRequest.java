package com.bbeltranl.evaluation.dto;

import com.bbeltranl.evaluation.model.Phone;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRequest {

    @NotBlank(message = "Nombre requerido")
    private String name;

    @NotBlank(message = "Email requerido")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Formato de correo electrónico inválido")
    //@Email(message = "Formato de correo electrónico inválido")
    private String email;

    @NotBlank(message = "Password requerida")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$", message = "La contraseña debe contener al menos 8 caracteres, una letra mayúscula, una letra minúscula, un dígito y un carácter especial")
    private String password;

    private List<Phone> phones;
}
