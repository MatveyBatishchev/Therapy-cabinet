package ru.mospolytech.therapy_cabinet.models.domain;

import org.joda.time.LocalDate;

import java.util.UUID;

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

    public void setId(UUID id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAdverseReactions(String adverseReactions) {
        this.adverseReactions = adverseReactions;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public UUID getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAdverseReactions() {
        return adverseReactions;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Sex getSex() {
        return sex;
    }
}
