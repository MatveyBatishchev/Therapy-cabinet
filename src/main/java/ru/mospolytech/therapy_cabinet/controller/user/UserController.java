package ru.mospolytech.therapy_cabinet.controller.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.mospolytech.therapy_cabinet.models.domain.user.User;
import ru.mospolytech.therapy_cabinet.models.dto.user.UserDTO;
import ru.mospolytech.therapy_cabinet.models.dto.user.UserRegistrationRequest;

import java.util.List;

/**
 * @author Dimevision
 * @version 0.1
 */

@RequestMapping("/user")
@Tag(name = "Пользователь")
public interface UserController {

    @GetMapping
    @Operation(
            summary = "Получить список всех пользователей",
            description = "offset - смещение списка, limit - ограничитель по выводимому количеству"
    )
    @ResponseStatus(HttpStatus.OK)
    List<UserDTO> findAllUsers(
            @RequestParam("offset") Long offset,
            @RequestParam("limit") Long limit
    );

    @GetMapping("/{id}")
    @Operation(summary = "Получить пользователя по ID")
    @ResponseStatus(HttpStatus.OK)
    UserDTO findUserById(@PathVariable("id") Integer userId);

    @PostMapping
    @Operation(summary = "Создать нового пользователя")
    @ResponseStatus(HttpStatus.OK)
    User createUser(@RequestBody UserRegistrationRequest user);

    @PutMapping
    @Operation(summary = "Обновить данные пользователя")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateUser(@RequestBody User user);

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить пользователя по ID")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteUser(@PathVariable("id") Integer userId);
}
