package ru.mospolytech.therapy_cabinet.models.domain.medindex;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MedIndexCreate extends MedIndex {

    /**
     * Идентификатор терапии
     */
    private int therapyId;

    /**
     * Вид индекса
     */
    private int indexTypeId;

}
