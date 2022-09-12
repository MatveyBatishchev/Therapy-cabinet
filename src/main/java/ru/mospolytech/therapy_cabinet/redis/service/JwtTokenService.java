package ru.mospolytech.therapy_cabinet.redis.service;

import java.util.Map;

/**
 * @author Dimevision
 * @version 0.1
 */

public interface JwtTokenService {

    Map<String, Object> generateJwtTokens(String username);
}
