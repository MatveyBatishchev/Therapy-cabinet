package ru.mospolytech.therapy_cabinet.service.user;

import ru.mospolytech.therapy_cabinet.models.domain.user.User;
import ru.mospolytech.therapy_cabinet.models.dto.user.*;

import java.util.List;

/**
 * @author Dimevision
 * @version 0.1
 */

public interface UserService {

    List<UserDTO> findAllUsers(Long offset, Long limit);

    UserDTO findUserById(Integer userId);

    UserDTO findUserByUsername(String username);

    User createUser(UserRegistrationRequest userRegistrationRequest);

    void updateUser(Integer userId, User user);

    void deleteUser(Integer userId);
}
