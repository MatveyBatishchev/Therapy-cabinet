package ru.mospolytech.therapy_cabinet.controller.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mospolytech.therapy_cabinet.models.dto.user.LoginRequest;
import ru.mospolytech.therapy_cabinet.models.dto.user.RefreshTokenRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import java.io.IOException;

import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;

/**
 * @author Dimevision
 * @version 0.1
 */

@RequestMapping("/api/v1")
@Tag(name = "Auth")
public interface UserAuthController {

    @PostMapping("/logout")
    @Operation(summary = "Logout")
    ResponseEntity<Void> logout(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest);

    @PostMapping("/refresh")
    @Operation(summary = "Обновить JWT токены")
    ResponseEntity<Void> refreshToken(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest, HttpServletRequest request, HttpServletResponse response) throws IOException;

    @PostMapping(
            path = "/login",
            consumes = APPLICATION_FORM_URLENCODED_VALUE
    )
    @Operation(summary = "Login")
    default void login(@Valid @NotBlank @RequestBody LoginRequest loginRequest) {
    }
}
