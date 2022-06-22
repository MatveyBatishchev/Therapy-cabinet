package ru.mospolytech.therapy_cabinet.controller.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.mospolytech.therapy_cabinet.models.dto.user.RefreshTokenRequest;
import ru.mospolytech.therapy_cabinet.service.user.UserServiceImplementation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Dimevision
 * @version 0.1
 */

@RestController
@RequiredArgsConstructor
public class UserAuthControllerImplementation implements UserAuthController {

    private final UserServiceImplementation userService;

    @Override
    public ResponseEntity<Void> logout(RefreshTokenRequest refreshTokenRequest) {
        userService.invalidateToken(refreshTokenRequest);

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> refreshToken(RefreshTokenRequest refreshTokenRequest, HttpServletRequest request, HttpServletResponse response) throws IOException {
        userService.refreshToken(refreshTokenRequest, request, response);

        return ResponseEntity.ok().build();
    }
}
