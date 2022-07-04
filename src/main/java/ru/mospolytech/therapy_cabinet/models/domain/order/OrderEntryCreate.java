package ru.mospolytech.therapy_cabinet.models.domain.order;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
public class OrderEntryCreate extends OrderEntry {

    /**
     * Идентификатор препарата в записи заказа
     */
    private Integer medicationId;

    /**
     * Идентифкатор заказ, к которму прикреплена запись
     */
    private Integer medOrderId;

}
