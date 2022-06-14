package ru.mospolytech.therapy_cabinet.models.domain.order;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
public class OrderEntryCreate extends OrderEntry {

    /**
     * Идентификатор препарата в записи заказа
     */
    private UUID medicationId;

    /**
     * Идентифкатор заказ, к которму прикреплена запись
     */
    private UUID medOrderId;

}
