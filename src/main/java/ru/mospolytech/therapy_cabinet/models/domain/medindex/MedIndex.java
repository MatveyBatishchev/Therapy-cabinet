package ru.mospolytech.therapy_cabinet.models.domain.medindex;

import lombok.Data;

import java.util.UUID;

@Data
public class MedIndex {

    /**
     * Идентификатор записи и клиническом индексе
     */
    private UUID id;

    /**
     * Значение индекса
     */
    private double value;

    /**
     * Примечание специалиста
     */
    private String comments;

    /**
     * Отклонение от нормы
     */
    private boolean abnormalityFlag;

}
