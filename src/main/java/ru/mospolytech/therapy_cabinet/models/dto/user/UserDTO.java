package ru.mospolytech.therapy_cabinet.models.dto.user;

import lombok.Data;
import ru.mospolytech.therapy_cabinet.models.domain.user.Authority;

import java.util.List;

/**
 * @author Dimevision
 * @version 0.1
 */

@Data
public class UserDTO {

    private Integer id;

    private String login;

    private List<Authority> roles;
}
