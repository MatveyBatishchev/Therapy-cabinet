package ru.mospolytech.therapy_cabinet.service.user;

import org.springframework.http.ResponseEntity;
import ru.mospolytech.therapy_cabinet.models.dto.user.LoginRequest;
import ru.mospolytech.therapy_cabinet.models.dto.user.LoginResponse;
import ru.mospolytech.therapy_cabinet.models.dto.user.RefreshTokenResponse;

import java.util.Map;

/**
 * @author Dimevision
 * @version 0.1
 */

public interface UserAuthService {

    ResponseEntity<LoginResponse> login(LoginRequest loginRequest);

    ResponseEntity<RefreshTokenResponse> refreshToken(String tokenRequest);

    ResponseEntity<Map<String, Object>> logout(String refreshToken);
}
