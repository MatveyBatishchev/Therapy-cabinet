package ru.mospolytech.therapy_cabinet.service.user;

import org.springframework.web.bind.annotation.RequestParam;
import ru.mospolytech.therapy_cabinet.models.domain.user.User;
import ru.mospolytech.therapy_cabinet.models.dto.user.UserDTO;

import java.util.List;
import java.util.UUID;

/**
 * @author Dimevision
 * @version 0.1
 */

public interface UserService {

    List<User> findAllUsers(Long offset, Long limit);

    User findUserById(UUID userId);

    UUID createUser(UserDTO userDTO);

    void updateUser(User user);

    void deleteUser(UUID userId);

    void verifyRegistrationToken(@RequestParam("token") UUID token);
}
