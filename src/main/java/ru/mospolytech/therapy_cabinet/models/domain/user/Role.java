package ru.mospolytech.therapy_cabinet.models.domain.user;

import lombok.Data;

/**
 * @author Dimevision
 * @version 0.1
 */

@Data
public class Role {
    /**
     * UUID роли (первичный ключ)
     */
    private Integer id;
    /**
     * Наименование пользовательской роли
     */
    private Authority roleName;
//    /**
//     * Множество пользователей роли
//     */
}
