package ru.mospolytech.therapy_cabinet.models.domain.therapy;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.mospolytech.therapy_cabinet.models.domain.Patient;

@Data
@EqualsAndHashCode(callSuper = true)
public class TherapyRead extends Therapy {

    /**
     * Объект пациента
     */
    private Patient patient;

}
