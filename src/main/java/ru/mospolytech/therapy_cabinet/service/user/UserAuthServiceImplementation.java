package ru.mospolytech.therapy_cabinet.service.user;

import com.auth0.jwt.exceptions.TokenExpiredException;
import common.util.CookieUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.mospolytech.therapy_cabinet.exception.EntityNotFoundException;
import ru.mospolytech.therapy_cabinet.models.domain.redis.RefreshToken;
import ru.mospolytech.therapy_cabinet.models.domain.user.User;
import ru.mospolytech.therapy_cabinet.models.dto.user.LoginRequest;
import ru.mospolytech.therapy_cabinet.models.dto.user.LoginResponse;
import ru.mospolytech.therapy_cabinet.models.dto.user.RefreshTokenResponse;
import ru.mospolytech.therapy_cabinet.models.dto.user.UserDTO;
import ru.mospolytech.therapy_cabinet.mybatis.mappers.UserMapper;
import ru.mospolytech.therapy_cabinet.redis.repository.RefreshTokenRepository;
import ru.mospolytech.therapy_cabinet.redis.service.JwtTokenService;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpHeaders.SET_COOKIE;
import static ru.mospolytech.therapy_cabinet.exception.EntityNotFoundException.NOT_EXISTS;

/**
 * @author Dimevision
 * @version 0.1
 */

@Service
@RequiredArgsConstructor
public class UserAuthServiceImplementation implements UserAuthService {

    private final AuthenticationManager authenticationManager;
    private final CookieUtil cookieUtil;

    private final UserMapper userMapper;
    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtTokenService jwtTokenService;

    @Override
    public ResponseEntity<LoginResponse> login(LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        User user = userMapper.findAuthenticatedUserByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException(String.format(NOT_EXISTS, "User: " + username)));

        refreshTokenRepository.findByUserId(user.getId())
                .ifPresent(token -> refreshTokenRepository.deleteByTokenAndUserId(token.getToken(), token.getUserId()));

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        Map<String, Object> tokens = jwtTokenService.generateJwtTokens(username);

        String access = tokens.get("access_token").toString();
        String refresh = tokens.get("refresh_token").toString();

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add(SET_COOKIE, cookieUtil.createAccessTokenCookie(access).toString());
        responseHeaders.add(SET_COOKIE, cookieUtil.createRefreshTokenCookie(refresh).toString());

        LoginResponse response = LoginResponse.builder()
                .accessToken(refresh)
                .user((UserDTO) tokens.get("user"))
                .build();

        return ResponseEntity.ok().headers(responseHeaders).body(response);
    }

    @Override
    public ResponseEntity<RefreshTokenResponse> refreshToken(String tokenRequest) {
        RefreshToken token = refreshTokenRepository.findByToken(tokenRequest)
                .orElseThrow(() -> new TokenExpiredException("Token either no more available or doesn't exists"));

        refreshTokenRepository.deleteByTokenAndUserId(token.getToken(), token.getUserId());

        UserDTO userDTO = userMapper.findUserById(token.getUserId())
                .orElseThrow();

        Map<String, Object> refreshedTokens = jwtTokenService.generateJwtTokens(userDTO.getLogin());
        String accessToken = refreshedTokens.get("access_token").toString();
        String refreshToken = refreshedTokens.get("refresh_token").toString();
        RefreshTokenResponse refreshTokenResponse = RefreshTokenResponse.builder()
                .accessToken(refreshToken)
                .user(userDTO)
                .build();

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add(SET_COOKIE, cookieUtil.createAccessTokenCookie(accessToken).toString());
        responseHeaders.add(SET_COOKIE, cookieUtil.createRefreshTokenCookie(refreshToken).toString());

        return ResponseEntity.ok().headers(responseHeaders).body(refreshTokenResponse);
    }

    @Override
    public ResponseEntity<Map<String, Object>> logout(String refreshToken) {
        cookieUtil.deleteAccessTokenCookie();

        RefreshToken token = refreshTokenRepository.findByToken(refreshToken)
                .orElseThrow(() ->
                        new EntityNotFoundException(String.format(NOT_EXISTS, "Token")));

        refreshTokenRepository.deleteByUserId(token.getUserId());
        refreshTokenRepository.deleteByToken(token.getToken());

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add(SET_COOKIE, cookieUtil.createRefreshTokenCookie("invalidated").toString());
        responseHeaders.add(SET_COOKIE, cookieUtil.createAccessTokenCookie("invalidated").toString());

        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("message", "Logout successfull. Access token was invalidated");
        responseBody.put("time", LocalDateTime.now());

        return ResponseEntity.ok().headers(responseHeaders).body(responseBody);
    }
}
