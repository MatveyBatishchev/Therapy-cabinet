package ru.mospolytech.therapy_cabinet.redis.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import ru.mospolytech.therapy_cabinet.models.domain.redis.RefreshToken;

import java.util.Optional;

/**
 * @author Dimevision
 * @version 0.1
 */

@Repository
@RequiredArgsConstructor
public class RefreshTokenRepository {

    public static final String HASH_KEY = "RefreshToken";

    private final RedisTemplate<String, Object> redisTemplate;

    public void save(RefreshToken refreshToken) {
        redisTemplate.opsForHash().put(HASH_KEY, refreshToken.getUserId(), refreshToken);
        redisTemplate.opsForHash().put(HASH_KEY, refreshToken.getToken(), refreshToken);
    }

    public Optional<RefreshToken> findByToken(String token) {
        return Optional.ofNullable((RefreshToken) redisTemplate.opsForHash().get(HASH_KEY, token));
    }

    public Optional<RefreshToken> findByUserId(Integer userId) {
        System.out.println("keys:" + redisTemplate.opsForHash().keys(HASH_KEY));
        return Optional.ofNullable((RefreshToken) redisTemplate.opsForHash().get(HASH_KEY, userId));
    }

    public void deleteByToken(String token) {
        redisTemplate.opsForHash().delete(HASH_KEY, token);
    }

    public void deleteByUserId(Integer userId) {
        redisTemplate.opsForHash().delete(HASH_KEY, userId);
    }

    public void deleteByTokenAndUserId(String token, Integer userId) {
        redisTemplate.opsForHash().delete(HASH_KEY, token);
        redisTemplate.opsForHash().delete(HASH_KEY, userId);
    }
}
