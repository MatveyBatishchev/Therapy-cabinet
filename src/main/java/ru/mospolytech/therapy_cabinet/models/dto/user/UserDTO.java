package ru.mospolytech.therapy_cabinet.models.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mospolytech.therapy_cabinet.models.domain.user.Authority;

import java.util.List;

/**
 * @author Dimevision
 * @version 0.1
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
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
     * Множество ролей пользователя
     */
    private List<Authority> roles;
}
