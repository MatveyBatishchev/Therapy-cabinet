package ru.mospolytech.therapy_cabinet.models.domain.therapy;

/**
 * Временной период проведения терапии
 */
public enum TimePeriod {

    MORNING(0),
    DAY(1);

    private final int code;

    TimePeriod(int code) {
        this.code = code;
    }

    /**
     * @return код статуса терапии
     */
    public int getCode() {
        return code;
    }

}
