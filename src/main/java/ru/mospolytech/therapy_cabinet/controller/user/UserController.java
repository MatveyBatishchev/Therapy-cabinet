package ru.mospolytech.therapy_cabinet.controller.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mospolytech.therapy_cabinet.models.domain.user.User;
import ru.mospolytech.therapy_cabinet.models.domain.user.VerificationToken;
import ru.mospolytech.therapy_cabinet.models.dto.user.UserDTO;

import java.util.List;
import java.util.UUID;

/**
 * @author Dimevision
 * @version 0.1
 */

@RequestMapping("/users")
@Tag(name = "Пользователь", description = "URL эндпоинты для работы с пользователями")
public interface UserController {

    @GetMapping
    @Operation(
            summary = "Получить список всех пользователей",
            description = "offset - смещение списка, limit - ограничитель по выводимому количеству"
    )
    ResponseEntity<List<User>> findAllUsers(
            @RequestParam("offset") Long offset,
            @RequestParam("limit") Long limit
    );

    @GetMapping("/{id}")
    @Operation(summary = "Получить пользователя по UUID")
    ResponseEntity<User> findUserById(@PathVariable("id") UUID userId);

    @PostMapping
    @Operation(summary = "Создать нового пользователя")
    ResponseEntity<UUID> createUser(@RequestBody UserDTO user);

    @GetMapping("/confirm")
    @Operation(summary = "Подтвердить регистрацию")
    ResponseEntity<VerificationToken> verifyRegistrationToken(@RequestParam(name = "token") UUID token);

    @PutMapping
    @Operation(summary = "Обновить данные пользователя")
    ResponseEntity<User> updateUser(@RequestBody User user);

    @DeleteMapping
    @Operation(summary = "Удалить пользователя по UUID")
    ResponseEntity<Void> deleteUser(@RequestBody UUID userId);
}
