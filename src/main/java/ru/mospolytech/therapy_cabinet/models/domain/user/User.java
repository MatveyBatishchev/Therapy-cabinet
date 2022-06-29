package ru.mospolytech.therapy_cabinet.models.domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

/**
 * @author Dimevision
 * @version 0.1
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    /**
     * Идентификатор пользователя
     */
    private UUID id;
    /**
     * Email пользователя
     */
    private String login;
    /**
     * Пароль для входа (ключ шифрования BCrypt)
     */
    private String password;
    /**
     * Множество ролей пользователя
     */
    private List<Authority> roles;
}
