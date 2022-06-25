package ru.mospolytech.therapy_cabinet.models.domain;

/**
 * Типы вычисляемых для пациента индексов
 */
public enum IndexType {

    SDAI(0),
    DAS(1),
    BASDAI(2);

    private final int code;

    IndexType(int code) {
        this.code = code;
    }

    /**
     * @return возвращает код типа индекса
     */
    public int getCode() {
        return code;
    }

}
