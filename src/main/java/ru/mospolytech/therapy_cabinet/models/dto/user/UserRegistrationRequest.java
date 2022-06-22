package ru.mospolytech.therapy_cabinet.models.dto.user;

import lombok.Data;
import ru.mospolytech.therapy_cabinet.models.domain.user.Authority;

import java.util.List;

/**
 * @author Dimevision
 * @version 0.1
 * <p>
 * DTO для модели @{@link ru.mospolytech.therapy_cabinet.models.domain.user.User}
 */

@Data
public class UserRegistrationRequest {
    /**
     * Логин пользователя
     */
    private String username;
    /**
     * Пароль для входа (ключ шифрования BCrypt)
     */
    private String password;
    /**
     * Роли пользователя
     */
    private List<Authority> roles;
}
