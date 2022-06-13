package ru.mospolytech.therapy_cabinet.models.domain.therapy;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
public class TherapyCreate extends Therapy {

    /**
     * Идентификатор пациента
     */
    private UUID patientId;

}
