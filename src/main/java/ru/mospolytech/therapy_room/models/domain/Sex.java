package ru.mospolytech.therapy_room.models.domain;

/**
 * Пол человека в формате ISO/IEC 5218
 */
public enum Sex {
    NOT_KNOWN(0),
    MALE(1),
    FEMALE(2),
    NOT_APPLICABLE(9);

    private final int code;

    Sex(int code) {
        this.code = code;
    }

    /**
     * @return код пола в формате ISO/IEC 5218
     */
    public int getCode() {
        return code;
    }
}
