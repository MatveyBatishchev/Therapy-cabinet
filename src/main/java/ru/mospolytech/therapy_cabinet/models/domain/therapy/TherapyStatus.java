package ru.mospolytech.therapy_cabinet.models.domain.therapy;

/**
 * Статус терапии
 */
public enum TherapyStatus {

    NOT_NOTIFIED(0),
    NOTIFIED(1),
    NOT_COMING(2),
    FINISHED(3);

    private final int code;

    TherapyStatus(int code) {
        this.code = code;
    }

    /**
     * @return код статуса терапии
     */
    public int getCode() {
        return code;
    }

}

