package ru.mospolytech.therapy_cabinet.controller.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mospolytech.therapy_cabinet.models.dto.user.LoginRequest;
import ru.mospolytech.therapy_cabinet.models.dto.user.LoginResponse;
import ru.mospolytech.therapy_cabinet.models.dto.user.RefreshTokenResponse;

import javax.validation.Valid;
import java.util.Map;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author Dimevision
 * @version 0.1
 */

@RequestMapping(value = "/auth", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Auth")
public interface UserAuthController {

    @PostMapping("/logout")
    @Operation(summary = "Logout")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    ResponseEntity<Map<String, Object>> logout(
            @CookieValue(name = "refresh_token", required = false) String refreshToken,
            @RequestHeader(name = AUTHORIZATION, required = false) String bearerToken);

    @PostMapping("/refresh")
    @Operation(summary = "Обновить JWT токены")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<RefreshTokenResponse> refreshToken(@CookieValue(name = "access_token", required = false) String accessToken,
                                                      @CookieValue(name = "refresh_token", required = false) String refreshToken,
                                                      @RequestHeader(name = AUTHORIZATION, required = false) String bearerToken);

    @PostMapping(
            path = "/login",
            consumes = APPLICATION_FORM_URLENCODED_VALUE
    )
    @Operation(summary = "Login")
    ResponseEntity<LoginResponse> login(
            @Valid LoginRequest loginRequest
    );
}
