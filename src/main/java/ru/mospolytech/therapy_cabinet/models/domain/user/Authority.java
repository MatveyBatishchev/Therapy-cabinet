package ru.mospolytech.therapy_cabinet.models.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static ru.mospolytech.therapy_cabinet.models.domain.user.Permission.*;

/**
 * @author Dimevision
 * @version 0.1
 */

@AllArgsConstructor
@Getter
public enum Authority {

    ADMINISTRATOR(1, Set.of(ADMINISTRATOR_READ, ADMINISTRATOR_WRITE)),
    DOCTOR(2, Set.of(DOCTOR_READ, DOCTOR_WRITE)),
    OPERATOR(3, Set.of(OPERATOR_READ, OPERATOR_WRITE));

    private final int id;
    private final Set<Permission> permissions;

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return permissions.stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermissionName()))
                .collect(Collectors.toSet());
    }
}

