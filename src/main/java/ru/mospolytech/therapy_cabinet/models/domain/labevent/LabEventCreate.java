package ru.mospolytech.therapy_cabinet.models.domain.labevent;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper=true)
public class LabEventCreate extends LabEvent {
    /**
     * Идентификатор пациента
     */
    private Integer patientId;
    /**
     * Вид анализа
     */
    private int labTypeId;

}
