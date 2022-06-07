package ru.mospolytech.therapy_cabinet.models.domain;

import lombok.Data;
import org.joda.time.DateTime;

import java.util.UUID;

@Data
public abstract class LabEvent {
    /**
     * Идентификатор анализа
     */
    private UUID id;
    /**
     * Показатель
     */
    private String value;
    /**
     * Числовой показатель
     */
    private double valueNumeric;
    /**
     * Комментарий специалиста
     */
    private String comments;
    /**
     * Время взятия анализа
     */
    private DateTime taken;
    /**
     * Отклонение от нормы
     */
    private boolean abnormalityFlag;
}
