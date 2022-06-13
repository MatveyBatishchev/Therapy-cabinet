package ru.mospolytech.therapy_cabinet.models.domain.prescription;

/**
 * Тип введения лекарства
 */
public enum AdministrationType {

    SUBCUTANEOUS(0), // Подкожный
    INTRAVENOUS(1); // Внутривенный

    private final int code;

    AdministrationType(int code) {
        this.code = code;
    }

    /**
     * @return код тип введения лекарства
     */
    public int getCode() {
        return code;
    }

}
