package ru.mospolytech.therapy_cabinet.models.domain.labevent;

import lombok.Data;
import org.joda.time.DateTime;


@Data
public abstract class LabEvent {
    /**
     * Идентификатор анализа
     */
    private Integer id;
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
