package ru.mospolytech.therapy_cabinet.models.domain.order;

import lombok.Data;

@Data
public abstract class OrderEntry {

    /**
     * Идентификатор записи в заказе
     */
    private int id;

    /**
     * Кол-во препарата в записи заказа
     */
    private int amount;

}
