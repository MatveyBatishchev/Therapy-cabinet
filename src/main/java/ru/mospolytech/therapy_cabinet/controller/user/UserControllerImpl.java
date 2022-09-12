package ru.mospolytech.therapy_cabinet.controller.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.mospolytech.therapy_cabinet.models.domain.user.User;
import ru.mospolytech.therapy_cabinet.models.dto.user.UserDTO;
import ru.mospolytech.therapy_cabinet.models.dto.user.UserRegistrationRequest;
import ru.mospolytech.therapy_cabinet.service.user.UserServiceImplementation;

import java.util.List;


/**
 * @author Dimevision
 * @version 0.1
 */

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserServiceImplementation userService;

    @Override
    public List<UserDTO> findAllUsers(Long offset, Long limit) {
        return userService.findAllUsers(offset, limit);
    }

    @Override
    public UserDTO findUserById(Integer userId) {
        return userService.findUserById(userId);
    }

    @Override
    public User createUser(UserRegistrationRequest userRegistration) {
        return userService.createUser(userRegistration);
    }

    @Override
    public void updateUser(Integer userId, User user) {
        userService.updateUser(userId, user);
    }

    @Override
    public void deleteUser(Integer userId) {
        userService.deleteUser(userId);
    }
}
