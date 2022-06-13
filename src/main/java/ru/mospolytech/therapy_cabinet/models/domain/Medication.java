package ru.mospolytech.therapy_cabinet.models.domain;

import lombok.Data;

import java.util.UUID;

@Data
public class Medication {

    /**
     * Идентификатор лекарственного препарата
     */
    private UUID id;

    /**
     * Официальное название
     */
    private String name;

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

    /**
     * Количество в больнице в мелких единицах
     */
    private int amount;

}
