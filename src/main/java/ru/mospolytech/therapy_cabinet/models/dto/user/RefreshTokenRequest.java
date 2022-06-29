package ru.mospolytech.therapy_cabinet.models.dto.user;

import lombok.Data;

/**
 * @author Dimevision
 * @version 0.1
 */

@Data
public class RefreshTokenRequest {

    private String refreshToken;
}
