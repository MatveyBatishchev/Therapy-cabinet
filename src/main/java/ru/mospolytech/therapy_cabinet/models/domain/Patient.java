package ru.mospolytech.therapy_cabinet.models.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.joda.time.LocalDate;

import java.util.UUID;

@Data
public class Patient {
    /**
     * Идентификатор пациента
     */
    private UUID id;
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
}
