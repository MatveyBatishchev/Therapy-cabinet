package ru.mospolytech.therapy_cabinet.models.domain.therapy;

import lombok.Data;
import org.joda.time.DateTime;

@Data
public abstract class Therapy {
    /**
     * Идентификатор терапии
     */
    private int id;
    /**
     * Время начала терапии
     */
    private DateTime startTime;
    /**
     * Время окончания терапии
     */
    private DateTime endTime;
    /**
     * Кабинет, где будет проходить терапия
     */
    private String cabinet;
    /**
     * Статус терапии
     */
    private TherapyStatus status;
    /**
     * Примечание к терапии
     */
    private String comments;
}
