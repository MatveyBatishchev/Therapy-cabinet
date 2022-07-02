package ru.mospolytech.therapy_cabinet.models.domain.medindex;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.mospolytech.therapy_cabinet.models.domain.therapy.TherapyCreate;

@Data
@EqualsAndHashCode(callSuper = true)
public class MedIndexRead extends MedIndex {

    /**
     * Объект терапии
     */
    private TherapyCreate therapy;

}
