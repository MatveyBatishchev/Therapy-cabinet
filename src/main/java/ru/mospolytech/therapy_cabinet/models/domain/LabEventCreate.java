package ru.mospolytech.therapy_cabinet.models.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper=true)
public class LabEventCreate extends LabEvent {
    /**
     * Идентификатор пациента
     */
    private UUID patientId;
    /**
     * Вид анализа
     */
    private int labTypeId;

}
