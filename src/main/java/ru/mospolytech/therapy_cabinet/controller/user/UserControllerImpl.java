package ru.mospolytech.therapy_cabinet.controller.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.mospolytech.therapy_cabinet.models.domain.user.User;
import ru.mospolytech.therapy_cabinet.models.domain.user.VerificationToken;
import ru.mospolytech.therapy_cabinet.models.dto.user.UserDTO;
import ru.mospolytech.therapy_cabinet.service.user.UserServiceImplementation;

import java.util.List;
import java.util.UUID;

/**
 * @author Dimevision
 * @version 0.1
 */

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserServiceImplementation userService;

    @Override
    public ResponseEntity<List<User>> findAllUsers(Long offset, Long limit) {
        List<User> users = userService.findAllUsers(offset, limit);

        return ResponseEntity.ok(users);
    }

    @Override
    public ResponseEntity<User> findUserById(UUID userId) {
        User user = userService.findUserById(userId);

        return ResponseEntity.ok(user);
    }

    @Override
    public ResponseEntity<UUID> createUser(UserDTO userRegistration) {
        UUID tokenId = userService.createUser(userRegistration);

        return ResponseEntity.ok(tokenId);
    }

    @Override
    public ResponseEntity<VerificationToken> verifyRegistrationToken(UUID token) {
        userService.verifyRegistrationToken(token);

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<User> updateUser(User user) {
        userService.updateUser(user);

        return ResponseEntity.ok(user);
    }

    @Override
    public ResponseEntity<Void> deleteUser(UUID userId) {
        userService.deleteUser(userId);

        return ResponseEntity.ok().build();
    }
}
