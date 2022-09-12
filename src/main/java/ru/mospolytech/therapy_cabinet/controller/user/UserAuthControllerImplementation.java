package ru.mospolytech.therapy_cabinet.controller.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.mospolytech.therapy_cabinet.models.dto.user.LoginRequest;
import ru.mospolytech.therapy_cabinet.models.dto.user.LoginResponse;
import ru.mospolytech.therapy_cabinet.models.dto.user.RefreshTokenResponse;
import ru.mospolytech.therapy_cabinet.service.user.UserAuthService;

import java.util.Map;

/**
 * @author Dimevision
 * @version 0.1
 */

@RestController
@RequiredArgsConstructor
public class UserAuthControllerImplementation implements UserAuthController {

    private final UserAuthService userAuthService;

    @Override
    public ResponseEntity<Map<String, Object>> logout(String refreshToken, String bearerToken) {
        return bearerToken != null
                ? userAuthService.logout(bearerToken.substring(7))
                : userAuthService.logout(refreshToken);
    }

    @Override
    public ResponseEntity<RefreshTokenResponse> refreshToken(String accessToken, String refreshToken, String bearerToken) {
        if (bearerToken != null) {
            return userAuthService.refreshToken(bearerToken.substring(7));
        }
        return userAuthService.refreshToken(refreshToken);
    }

    @Override
    public ResponseEntity<LoginResponse> login(LoginRequest loginRequest) {
        return userAuthService.login(loginRequest);
    }
}
