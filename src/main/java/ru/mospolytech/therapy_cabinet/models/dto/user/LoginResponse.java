package ru.mospolytech.therapy_cabinet.models.dto.user;

import lombok.Builder;
import lombok.Data;

/**
 * @author Dimevision
 * @version 0.1
 */

@Builder
@Data
public class LoginResponse {

    private String accessToken;

    private UserDTO user;
}
