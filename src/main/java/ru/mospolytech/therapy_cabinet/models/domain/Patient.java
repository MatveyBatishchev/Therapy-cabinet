package ru.mospolytech.therapy_cabinet.models.domain;

import lombok.Data;
import org.joda.time.LocalDate;


@Data
public class Patient {
    /**
     * Идентификатор пациента
     */
    private Integer id;
    /**
     * ФИО пациента
     */
    private String fullName;
    /**
     * Номер телефона пациента
     */
    private String phoneNumber;
    /**
     * Нежелательные реакции
     */
    private String adverseReactions;
    /**
     * Дата рождения
     */
    private LocalDate dateOfBirth;
    /**
     * Пол пациента
     */
    private Sex sex;
    /**
     * Электронная почта пациента
     */
    private String email;
    /**
     * Телефонный номер контактного лица пациента
     */
    private String contactPerson;
    /**
     * Номер амбулаторной карты, для синхронизации с системой Interin
     */
    private String ambulatoryCard;
    /**
     * Источник финансирования пациента
     */
    private FinanceSource financeSource;
}
