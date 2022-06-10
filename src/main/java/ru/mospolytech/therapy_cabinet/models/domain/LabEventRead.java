package ru.mospolytech.therapy_cabinet.models.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
public class LabEventRead extends LabEvent {
    /**
     * Идентификатор анализа
     */
    private UUID id;
    /**
     * Идентификатор пациента
     */
    private Patient patient;
    /**
     * Вид анализа
     */
    private LabType labType;
}
