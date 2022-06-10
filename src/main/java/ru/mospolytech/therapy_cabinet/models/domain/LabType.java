package ru.mospolytech.therapy_cabinet.models.domain;

import lombok.Data;

@Data
public class LabType {
    /**
     * Идентификатор вида анализов
     */
    private int id;
    /**
     * Название анализа
     */
    private String name;
    /**
     * Биологический материал
     */
    private String specimen;
    /**
     * Единицы измерения
     */
    private String measurementUnits;
    /**
     * Нижняя граница нормы показателя
     */
    private String lowerLimit;
    /**
     * Числовая нижняя граница нормы показателя
     */
    private double lowerLimitNumeric;
    /**
     * Верхняя граница нормы показателя
     */
    private double upperLimit;
    /**
     * Числовая верхняя граница нормы показателя
     */
    private double upperLimitNumeric;
}
