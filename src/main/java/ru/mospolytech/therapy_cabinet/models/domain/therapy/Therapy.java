package ru.mospolytech.therapy_cabinet.models.domain.therapy;

import lombok.Data;
import org.joda.time.LocalDate;

@Data
public abstract class Therapy {
    /**
     * Идентификатор терапии
     */
    private int id;
    /**
     * Дата проведения терапии
     */
    private LocalDate date;
    /**
     * Временной период проведения терапии
     */
    private TimePeriod timePeriod;
    /**
     * Статус терапии
     */
    private TherapyStatus status;
    /**
     * Примечание к терапии
     */
    private String comments;
}
