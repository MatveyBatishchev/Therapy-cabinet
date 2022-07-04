package ru.mospolytech.therapy_cabinet.models.domain.medindex;

import lombok.Data;
import ru.mospolytech.therapy_cabinet.models.domain.IndexType;


@Data
public class MedIndex {

    /**
     * Идентификатор записи и клиническом индексе
     */
    private Integer id;

    /**
     * Значение индекса
     */
    private double value;

    /**
     * Примечание специалиста
     */
    private String comments;

    /**
     * Тип индекса
     */
    private IndexType indexType;

    /**
     * Отклонение от нормы
     */
    private boolean abnormalityFlag;

}
