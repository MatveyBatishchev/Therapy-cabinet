package ru.mospolytech.therapy_cabinet.models.dto.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Dimevision
 * @version 0.1
 */

@Data
public class LoginRequest {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
