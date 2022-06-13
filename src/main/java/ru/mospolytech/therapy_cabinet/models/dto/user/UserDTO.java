package ru.mospolytech.therapy_cabinet.models.dto.user;

import lombok.Data;
import ru.mospolytech.therapy_cabinet.models.domain.user.Role;

import java.util.Set;

/**
 * @author Dimevision
 * @version 0.1
 * <p>
 * DTO для модели @{@link ru.mospolytech.therapy_cabinet.models.domain.user.User}
 */

@Data
public class UserDTO {
    /**
     * Email пользователя
     */
    private String email;
    /**
     * Номер телефона пользователя
     */
    private String phoneNumber;
    /**
     * Пароль для входа (ключ шифрования BCrypt)
     */
    private String password;
    /**
     * Роли пользователя
     */
    private Set<Role> roles;
}
