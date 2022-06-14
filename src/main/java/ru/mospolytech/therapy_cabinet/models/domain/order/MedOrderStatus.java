package ru.mospolytech.therapy_cabinet.models.domain.order;

/**
 * Статус заказа в аптеку
 */
public enum MedOrderStatus {

    SEND(0),
    FORMING(1),
    FINISHED(2);

    private final int code;

    MedOrderStatus(int code) {
        this.code = code;
    }

    /**
     * @return код статуса заказ в аптеку
     */
    public int getCode() {
        return code;
    }

}
