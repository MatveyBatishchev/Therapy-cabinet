package ru.mospolytech.therapy_cabinet.models.dto.user;

import lombok.Data;
import ru.mospolytech.therapy_cabinet.models.domain.user.Authority;

import java.util.List;
import java.util.UUID;

/**
 * @author Dimevision
 * @version 0.1
 */

@Data
public class UserDTO {

    private UUID id;

    private String login;

    private List<Authority> roles;
}
