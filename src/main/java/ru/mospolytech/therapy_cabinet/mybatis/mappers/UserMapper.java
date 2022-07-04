package ru.mospolytech.therapy_cabinet.mybatis.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import ru.mospolytech.therapy_cabinet.models.domain.user.User;
import ru.mospolytech.therapy_cabinet.models.dto.user.UserDTO;

import java.util.List;
import java.util.Optional;

/**
 * @author Dimevision
 * @version 0.1
 */

@Component
@Mapper
public interface UserMapper {

    int createUser(@Param("user") User user);

    Optional<UserDTO> findUserById(@Param("id") Integer id);

    void updateUser(@Param("user") User user);

    void deleteUser(@Param("id") Integer id);

    List<UserDTO> findAllUsers(
            @Param("offset") Long offset,
            @Param("limit") Long limit
    );

    Optional<User> findUserByUsername(@Param("username") String username);
}
