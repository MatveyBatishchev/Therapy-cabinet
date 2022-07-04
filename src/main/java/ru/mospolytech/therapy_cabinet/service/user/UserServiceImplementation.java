package ru.mospolytech.therapy_cabinet.service.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mospolytech.therapy_cabinet.exception.EntityNotFoundException;
import ru.mospolytech.therapy_cabinet.models.domain.user.User;
import ru.mospolytech.therapy_cabinet.models.dto.user.RefreshTokenRequest;
import ru.mospolytech.therapy_cabinet.models.dto.user.UserDTO;
import ru.mospolytech.therapy_cabinet.models.dto.user.UserRegistrationRequest;
import ru.mospolytech.therapy_cabinet.mybatis.mappers.UserMapper;
import ru.mospolytech.therapy_cabinet.models.domain.redis.RefreshToken;
import ru.mospolytech.therapy_cabinet.redis.repository.RefreshTokenRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static ru.mospolytech.therapy_cabinet.exception.EntityNotFoundException.NOT_EXISTS;

/**
 * @author Dimevision
 * @version 0.1
 */

@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService {

    private final PasswordEncoder passwordEncoder;

    private final UserMapper userMapper;
    private final RefreshTokenRepository refreshTokenRepository;

    @Override
    @Transactional
    public User createUser(UserRegistrationRequest userRegistrationRequest) {
        boolean isAlreadyExists = userMapper.findUserByUsername(userRegistrationRequest.getUsername())
                .isPresent();

        if (isAlreadyExists) {
            throw new IllegalArgumentException(String.format(NOT_EXISTS, "User: " + userRegistrationRequest.getUsername()));
        }

        String password = passwordEncoder.encode(userRegistrationRequest.getPassword());

        User user = User.builder()
                .login(userRegistrationRequest.getUsername())
                .password(password)
                .roles(userRegistrationRequest.getRoles())
                .build();

        userMapper.createUser(user);
        user.setId(user.getId());

        return user;
    }

    @Override
    public void refreshToken(RefreshTokenRequest tokenRequest, HttpServletRequest request, HttpServletResponse response) throws IOException {
        RefreshToken token = refreshTokenRepository.findByToken(tokenRequest.getRefreshToken())
                .orElseThrow(() -> new IllegalArgumentException("Token either no more available or doesn't exists"));

        if (token.getExpiredAt().before(new Date(System.currentTimeMillis()))) {
            throw new IllegalArgumentException("Token has expired");
        }
        refreshTokenRepository.deleteByToken(token.getToken());

        UserDTO userDTO = userMapper.findUserById(token.getUserId())
                .orElseThrow();
        Map<String, Object> tokens = refreshTokenRepository.generateJwtTokens(userDTO.getLogin(), request);

        response.setContentType(APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(response.getOutputStream(), tokens);
    }

    @Override
    public UserDTO findUserById(Integer userId) {
        return userMapper.findUserById(userId)
                .orElseThrow(() ->
                        new EntityNotFoundException(String.format(NOT_EXISTS, "User id: " + userId)));
    }

    @Override
    public User findUserByUsername(String username) {
        return userMapper.findUserByUsername(username)
                .orElseThrow(() ->
                        new EntityNotFoundException(String.format(NOT_EXISTS, "User: " + username)));
    }

    @Override
    @Transactional
    public void deleteUser(Integer userId) {
        userMapper.deleteUser(userId);
    }

    @Override
    public void invalidateToken(RefreshTokenRequest refreshToken) {
        RefreshToken token = refreshTokenRepository.findByToken(refreshToken.getRefreshToken())
                .orElseThrow(() ->
                        new EntityNotFoundException(String.format(NOT_EXISTS, "Token: " + refreshToken)));

        refreshTokenRepository.deleteByToken(token.getToken());
    }

    @Override
    public void updateUser(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userMapper.updateUser(user);
    }

    @Override
    public List<UserDTO> findAllUsers(Long offset, Long limit) {
        return userMapper.findAllUsers(offset, limit);
    }
}
