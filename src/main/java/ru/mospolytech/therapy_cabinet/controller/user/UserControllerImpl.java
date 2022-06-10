package ru.mospolytech.therapy_cabinet.controller.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.mospolytech.therapy_cabinet.models.domain.user.User;
import ru.mospolytech.therapy_cabinet.mybatis.mappers.UserMapper;

import java.util.List;
import java.util.UUID;

/**
 * @author Dimevision
 * @version 0.1
 */

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserMapper userMapper;

    @Override
    public ResponseEntity<List<User>> findAllUsers(Long offset, Long limit) {
        List<User> users = userMapper.findAllUsers(offset, limit);

        return ResponseEntity.ok(users);
    }

    @Override
    public ResponseEntity<User> findUserById(UUID userId) {
        User user = userMapper.findUserById(userId);

        return ResponseEntity.ok(user);
    }

    @Override
    public ResponseEntity<User> createUser(User user) {
        userMapper.createUser(user);

        return ResponseEntity.ok(user);
    }

    @Override
    public ResponseEntity<Void> deleteUser(UUID userId) {
        userMapper.deleteUser(userId);

        return ResponseEntity.accepted().build();
    }

    @Override
    public ResponseEntity<Void> updateUser(User user) {

        return ResponseEntity.accepted().build();
    }
}
