package ru.mospolytech.therapy_cabinet.models.domain.prescription;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.mospolytech.therapy_cabinet.models.domain.Medication;
import ru.mospolytech.therapy_cabinet.models.domain.therapy.TherapyCreate;

@Data
@EqualsAndHashCode(callSuper = true)
public class PrescriptionRead extends Prescription {

    /**
     * Объекта лекарственного препарата
     */
    private Medication medication;

    /**
     * Объект терапии
     */
    private TherapyCreate therapy;

}
