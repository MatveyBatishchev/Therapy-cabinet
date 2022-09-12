package ru.mospolytech.therapy_cabinet.models.domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    private Integer id;
    /**
     * Email пользователя
     */
    private String login;
    /**
     * ФИО пользователя
     */
    private String fullName;
    /**
     * Пароль для входа (ключ шифрования BCrypt)
     */
    private String password;
    /**
     * Множество ролей пользователя
     */
    private List<Authority> roles;
}
