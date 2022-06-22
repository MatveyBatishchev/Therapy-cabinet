package ru.mospolytech.therapy_cabinet.models.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Dimevision
 * @version 0.1
 */

@AllArgsConstructor
@Getter
public enum Permission {
    ADMINISTRATOR_READ("administrator:read"),
    ADMINISTRATOR_WRITE("administrator:write"),
    DOCTOR_READ("doctor:read"),
    DOCTOR_WRITE("doctor:write"),
    OPERATOR_READ("operator:read"),
    OPERATOR_WRITE("operator:write");

    private final String permissionName;
}
