package ru.mospolytech.therapy_cabinet.models.domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;
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
     * Время создания аккаунта
     */
    private LocalDateTime createdAt;
    /**
     * Время обновления аккаунта
     */
    private LocalDateTime updatedAt;
    /**
     * Подтверждение регистрации
     */
    private Boolean isEnabled;
    /**
     * Множество ролей пользователя
     */
    private Set<Role> roles;
}
