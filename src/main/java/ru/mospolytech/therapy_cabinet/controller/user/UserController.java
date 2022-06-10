package ru.mospolytech.therapy_cabinet.controller.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mospolytech.therapy_cabinet.models.domain.user.User;

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
            description = "offset - , limit - "
    )
    ResponseEntity<List<User>> findAllUsers(
            @RequestParam("offset") Long offset,
            @RequestParam("limit") Long limit
    );

    @GetMapping("/{id}")
    @Operation(summary = "Получить пользователя по UUID")
    ResponseEntity<User> findUserById(@PathVariable("id") UUID userId);

    @PostMapping
    ResponseEntity<User> createUser(@RequestBody User user);

    @DeleteMapping
    ResponseEntity<Void> deleteUser(UUID userId);

    @PutMapping
    ResponseEntity<Void> updateUser(@RequestBody User user);
}
