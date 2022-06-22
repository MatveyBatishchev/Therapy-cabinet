package ru.mospolytech.therapy_cabinet.redis.repository;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;
import ru.mospolytech.therapy_cabinet.models.domain.user.User;
import ru.mospolytech.therapy_cabinet.mybatis.mappers.UserMapper;
import ru.mospolytech.therapy_cabinet.models.domain.redis.RefreshToken;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Dimevision
 * @version 0.1
 */

@Repository
@RequiredArgsConstructor
public class RefreshTokenRepository {

    public static final String HASH_KEY = "RefreshToken";
    private static final Date ACCESS_TOKEN_EXPIRES_AT = new Date(System.currentTimeMillis() + (30L * 24 * 60 * 60 * 1000));
    private static final Date REFRESH_TOKEN_EXPIRES_AT = new Date(System.currentTimeMillis() + (2 * 60 * 60 * 1000));

    private final RedisTemplate<String, Object> redisTemplate;

    private final UserMapper userMapper;

    public void save(RefreshToken refreshToken) {
        redisTemplate.opsForHash().put(HASH_KEY, refreshToken.getToken(), refreshToken);
    }

    public Optional<RefreshToken> findByToken(String token) {
        return Optional.ofNullable((RefreshToken) redisTemplate.opsForHash().get(HASH_KEY, token));
    }

    public void deleteByToken(String token) {
        redisTemplate.opsForHash().delete(HASH_KEY, token);
    }

    public Map<String, Object> generateJwtTokens(String username, HttpServletRequest request) {
        User user = userMapper.findUserByUsername(username).orElseThrow();
        List<SimpleGrantedAuthority> userAuthorities = user.getRoles().stream()
                .map(a -> new SimpleGrantedAuthority(a.name()))
                .collect(Collectors.toList());

        Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
        String accessToken = JWT.create()
                .withSubject(user.getLogin())
                .withExpiresAt(ACCESS_TOKEN_EXPIRES_AT)
                .withIssuer(request.getRequestURL().toString())
                .withClaim("roles", userAuthorities.toString())
                .sign(algorithm);

        String refreshToken = JWT.create()
                .withSubject(user.getLogin())
                .withExpiresAt(REFRESH_TOKEN_EXPIRES_AT)
                .withIssuer(request.getRequestURL().toString())
                .withClaim("roles", userAuthorities.toString())
                .sign(algorithm);

        RefreshToken token = RefreshToken.builder()
                .token(refreshToken)
                .expiredAt(REFRESH_TOKEN_EXPIRES_AT)
                .userId(user.getId().toString())
                .build();
        save(token);

        Map<String, Object> tokens = new HashMap<>();
        tokens.put("access_token", accessToken);
        tokens.put("refresh_token", refreshToken);

        return tokens;
    }
}
