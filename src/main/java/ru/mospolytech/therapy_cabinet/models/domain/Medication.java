package ru.mospolytech.therapy_cabinet.models.domain;

import lombok.Data;


@Data
public class Medication {
    /**
     * Идентификатор лекарственного препарата
     */
    private Integer id;
    /**
     * Номенклатура препарата
     */
    private String nomenclature;
    /**
     * Производитель
     */
    private String manufacturer;
    /**
     * Форма дозы
     */
    private String doseForm;
    /**
     * Количество вещества в дозе
     */
    private double doseVal;
    /**
     * Единицы измерения вещества
     */
    private String measurementUnits;
}
