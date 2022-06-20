package ru.mospolytech.therapy_cabinet.models.domain.medindex;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.mospolytech.therapy_cabinet.models.domain.IndexType;
import ru.mospolytech.therapy_cabinet.models.domain.therapy.TherapyRead;

@Data
@EqualsAndHashCode(callSuper = true)
public class MedIndexRead extends MedIndex {

    /**
     * Объект терапии
     */
    private TherapyRead therapy;

    /**
     * Объект типа индекса
     */
    private IndexType indexType;

}
