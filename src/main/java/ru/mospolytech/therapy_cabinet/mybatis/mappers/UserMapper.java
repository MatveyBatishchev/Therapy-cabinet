package ru.mospolytech.therapy_cabinet.mybatis.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import ru.mospolytech.therapy_cabinet.models.domain.user.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Dimevision
 * @version 0.1
 */

@Component
@Mapper
public interface UserMapper {

    void createUser(@Param("user") User user);

    Optional<User> findUserById(@Param("id") UUID id);

    void updateUser(@Param("user") User user);

    void deleteUser(@Param("id") UUID id);

    List<User> findAllUsers(
            @Param("offset") Long offset,
            @Param("limit") Long limit
    );

    Optional<User> findUserByEmail(@Param("email") String email);
}
