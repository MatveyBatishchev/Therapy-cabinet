package ru.mospolytech.therapy_cabinet.models.domain.user;

import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * @author Dimevision
 * @version 0.1
 */

@Data
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
    private LocalDate createdAt;
    /**
     * Время обновления аккаунта
     */
    private LocalDate updatedAt;
    /**
     * Подтверждение регистрации
     */
    private Boolean isEnabled;
    /**
     * Множество ролей пользователя
     */
    private Set<Role> roles = new HashSet<>();
}
