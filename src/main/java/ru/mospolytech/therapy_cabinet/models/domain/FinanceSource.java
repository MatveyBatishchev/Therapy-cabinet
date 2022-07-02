package ru.mospolytech.therapy_cabinet.models.domain;


/**
 * Источник финансирования пациента
 */
public enum FinanceSource {
    OMS(0), // полис ОМС
    DMS(1), // полис ДМС
    BUDGET(2); // бюджетная основа

    private final int code;

    FinanceSource(int code) {
        this.code = code;
    }

    /**
     * @return код источника финансирования
     */
    public int getCode() {
        return code;
    }
}