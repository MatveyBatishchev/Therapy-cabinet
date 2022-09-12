package ru.mospolytech.therapy_cabinet.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mospolytech.therapy_cabinet.exception.EntityNotFoundException;
import ru.mospolytech.therapy_cabinet.models.domain.user.User;
import ru.mospolytech.therapy_cabinet.models.dto.user.UserDTO;
import ru.mospolytech.therapy_cabinet.models.dto.user.UserRegistrationRequest;
import ru.mospolytech.therapy_cabinet.mybatis.mappers.UserMapper;

import java.util.List;

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
    public UserDTO findUserById(Integer userId) {
        return userMapper.findUserById(userId)
                .orElseThrow(() ->
                        new EntityNotFoundException(String.format(NOT_EXISTS, "User id: " + userId)));
    }

    @Override
    public UserDTO findUserByUsername(String username) {
        return userMapper.findUserByUsername(username)
                .orElseThrow(() ->
                        new EntityNotFoundException(String.format(NOT_EXISTS, "User: " + username)));
    }

    @Override
    public void deleteUser(Integer userId) {
        userMapper.deleteUser(userId);
    }

    @Override
    public void updateUser(Integer userId, User user) {
        if (user.getPassword() != null) {
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
        }

        userMapper.updateUser(userId, user);
    }

    @Override
    public List<UserDTO> findAllUsers(Long offset, Long limit) {
        return userMapper.findAllUsers(offset, limit);
    }
}
