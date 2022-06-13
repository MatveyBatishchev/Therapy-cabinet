package ru.mospolytech.therapy_cabinet.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;
import ru.mospolytech.therapy_cabinet.models.domain.user.User;
import ru.mospolytech.therapy_cabinet.models.domain.user.VerificationToken;
import ru.mospolytech.therapy_cabinet.models.dto.user.UserDTO;
import ru.mospolytech.therapy_cabinet.mybatis.mappers.UserMapper;
import ru.mospolytech.therapy_cabinet.mybatis.mappers.VerificationTokenMapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * @author Dimevision
 * @version 0.1
 */

@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService {

    private final PasswordEncoder passwordEncoder;

    private final UserMapper userMapper;
    private final VerificationTokenMapper tokenMapper;

    @Override
    @Transactional
    public UUID createUser(UserDTO userDTO) {
        String password = passwordEncoder.encode(userDTO.getPassword());
        User user = User.builder()
                .id(UUID.randomUUID())
                .email(userDTO.getEmail())
                .phoneNumber(userDTO.getPhoneNumber())
                .password(password)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .roles(userDTO.getRoles())
                .isEnabled(false)
                .build();

        VerificationToken token = VerificationToken.builder()
                .token(UUID.randomUUID())
                .userUuid(user.getId())
                .createdAt(LocalDateTime.now())
                .expiredAt(LocalDateTime.now().plusHours(2))
                .confirmedAt(null)
                .build();

        userMapper.createUser(user);
        tokenMapper.saveVerificationToken(token);

        return token.getToken();
    }

    @Override
    @Transactional
    public void verifyRegistrationToken(UUID token) {
        VerificationToken verificationToken = tokenMapper.findByToken(token)
                .orElseThrow(() -> new NotFoundException(String.format("Token: %s not exists", token.toString())));
        if (verificationToken.getExpiredAt().isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("Token expired at " + verificationToken.getExpiredAt());
        } else if (verificationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("Token has already been confirmed");
        } else {
            verificationToken.setConfirmedAt(LocalDateTime.now());

            UUID userUuid = verificationToken.getUserUuid();
            User user = userMapper.findUserById(userUuid)
                    .orElseThrow(() ->
                            new NotFoundException(String.format("User: %s not exists in database", userUuid)));
            user.setIsEnabled(true);
            userMapper.updateUser(user);
        }

        tokenMapper.updateVerificationToken(verificationToken);
    }

    @Override
    public User findUserById(UUID userId) {
        return userMapper.findUserById(userId)
                .orElseThrow(() ->
                        new NotFoundException(String.format("User: %s not exists in database", userId)));
    }

    @Override
    @Transactional
    public void deleteUser(UUID userId) {

        userMapper.deleteUser(userId);
    }

    @Override
    public void updateUser(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setUpdatedAt(LocalDateTime.now());

        userMapper.updateUser(user);
    }

    @Override
    public List<User> findAllUsers(Long offset, Long limit) {
        return userMapper.findAllUsers(offset, limit);
    }
}
