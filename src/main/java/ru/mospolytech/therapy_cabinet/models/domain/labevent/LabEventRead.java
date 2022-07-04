package ru.mospolytech.therapy_cabinet.models.domain.labevent;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.mospolytech.therapy_cabinet.models.domain.LabType;
import ru.mospolytech.therapy_cabinet.models.domain.Patient;


@Data
@EqualsAndHashCode(callSuper = true)
public class LabEventRead extends LabEvent {
    /**
     * Идентификатор анализа
     */
    private Integer id;
    /**
     * Идентификатор пациента
     */
    private Patient patient;
    /**
     * Вид анализа
     */
    private LabType labType;
}
