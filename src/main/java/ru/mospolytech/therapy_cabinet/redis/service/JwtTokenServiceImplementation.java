package ru.mospolytech.therapy_cabinet.redis.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.RequiredArgsConstructor;
import org.joda.time.DateTime;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import ru.mospolytech.therapy_cabinet.exception.EntityNotFoundException;
import ru.mospolytech.therapy_cabinet.models.domain.redis.RefreshToken;
import ru.mospolytech.therapy_cabinet.models.dto.user.UserDTO;
import ru.mospolytech.therapy_cabinet.mybatis.mappers.UserMapper;
import ru.mospolytech.therapy_cabinet.redis.repository.RefreshTokenRepository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static ru.mospolytech.therapy_cabinet.exception.EntityNotFoundException.NOT_EXISTS;

/**
 * @author Dimevision
 * @version 0.1
 */

@Service
@RequiredArgsConstructor
public class JwtTokenServiceImplementation implements JwtTokenService {

    private final RefreshTokenRepository refreshTokenRepository;

    private final UserMapper userMapper;

    @Override
    public Map<String, Object> generateJwtTokens(String username) {
        final Date accessTokenExpiresAt = new Date(System.currentTimeMillis() + (30L * 24 * 60 * 60 * 1000));
        final Date refreshTokenExpiresAt = new Date(System.currentTimeMillis() + (15 * 24 * 60 * 60 * 1000));

        UserDTO user = userMapper.findUserByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException(String.format(NOT_EXISTS, "User: " + username)));

        List<SimpleGrantedAuthority> userAuthorities = user.getRoles().stream()
                .map(a -> new SimpleGrantedAuthority(a.name()))
                .collect(Collectors.toList());

        Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());

        Date issuedAt = DateTime.now().toDate();
        String accessToken = JWT.create()
                .withSubject(user.getLogin())
                .withIssuedAt(issuedAt)
                .withExpiresAt(accessTokenExpiresAt)
                .withClaim("roles", userAuthorities.toString())
                .sign(algorithm);

        String refreshToken = JWT.create()
                .withSubject(user.getLogin())
                .withIssuedAt(issuedAt)
                .withExpiresAt(refreshTokenExpiresAt)
                .withClaim("roles", userAuthorities.toString())
                .sign(algorithm);

        RefreshToken token = RefreshToken.builder()
                .token(refreshToken)
                .expiredAt(refreshTokenExpiresAt)
                .userId(user.getId())
                .build();
        refreshTokenRepository.save(token);

        Map<String, Object> tokens = new HashMap<>();
        tokens.put("access_token", accessToken);
        tokens.put("refresh_token", refreshToken);
        tokens.put("user", user);

        return tokens;
    }
}
