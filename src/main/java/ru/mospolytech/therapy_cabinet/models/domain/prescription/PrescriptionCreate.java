package ru.mospolytech.therapy_cabinet.models.domain.prescription;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
public class PrescriptionCreate extends Prescription {

    /**
     * Идентификатор лекарственного препарата
     */
    private Integer medicationId;

    /**
     * Идентификатор терапии
     */
    private int therapyId;

}
