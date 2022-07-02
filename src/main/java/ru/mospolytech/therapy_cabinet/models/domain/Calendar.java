package ru.mospolytech.therapy_cabinet.models.domain;

import lombok.Data;
import org.joda.time.LocalDate;

@Data
public class Calendar {

    private LocalDate date;

    private int morningCount;

    private int dayCount;

}
