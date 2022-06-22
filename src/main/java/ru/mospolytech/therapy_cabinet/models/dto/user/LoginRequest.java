package ru.mospolytech.therapy_cabinet.models.dto.user;

import lombok.Data;

/**
 * @author Dimevision
 * @version 0.1
 */

@Data
public class LoginRequest {

    private String username;

    private String password;
}
