package ru.mospolytech.therapy_cabinet.models.domain.prescription;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
public class PrescriptionCreate extends Prescription {

    /**
     * Идентификатор лекарственного препарата
     */
    private UUID medicationId;

    /**
     * Идентификатор терапии
     */
    private int therapyId;

}
