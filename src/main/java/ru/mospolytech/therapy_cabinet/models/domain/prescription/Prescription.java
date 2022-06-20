package ru.mospolytech.therapy_cabinet.models.domain.prescription;

import lombok.Data;

import java.util.UUID;

@Data
public abstract class Prescription {

    /**
     * Идентификатор лекарственного назначения
     */
    private UUID id;

    /**
     * Кол-во списанного к терапии лекарства в дозах
     */
    private int doseAmount;

    /**
     * Кол-во списанного к терапии вещества лекарства
     */
    private double substanceAmount;

    /**
     * Примечание к лекарственному назначению
     */
    private String comments;

    /**
     * Тип введения лекарства
     */
    private AdministrationType administrationType;

}