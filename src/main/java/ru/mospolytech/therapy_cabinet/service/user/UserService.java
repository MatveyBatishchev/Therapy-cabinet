package ru.mospolytech.therapy_cabinet.service.user;

import ru.mospolytech.therapy_cabinet.models.domain.user.User;
import ru.mospolytech.therapy_cabinet.models.dto.user.RefreshTokenRequest;
import ru.mospolytech.therapy_cabinet.models.dto.user.UserDTO;
import ru.mospolytech.therapy_cabinet.models.dto.user.UserRegistrationRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Dimevision
 * @version 0.1
 */

public interface UserService {

    List<UserDTO> findAllUsers(Long offset, Long limit);

    UserDTO findUserById(Integer userId);

    User findUserByUsername(String username);

    User createUser(UserRegistrationRequest userRegistrationRequest);

    void updateUser(User user);

    void deleteUser(Integer userId);

    void invalidateToken(RefreshTokenRequest refreshToken);

    void refreshToken(RefreshTokenRequest tokenRequest, HttpServletRequest request, HttpServletResponse response) throws IOException;
}
