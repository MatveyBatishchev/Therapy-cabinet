package ru.mospolytech.therapy_cabinet.models.domain;

import lombok.Data;

@Data
public class IndexType {

    /**
     * Идентификатор типа анализа
     */
    private int id;

    /**
     * Официальное название индекса
     */
    private String name;

    /**
     * Нижняя граница нормы показателя
     */
    private double lowerLimitNumeric;

    /**
     * Верхняя граница нормы показателя
     */
    private double upperLimitNumeric;

}
