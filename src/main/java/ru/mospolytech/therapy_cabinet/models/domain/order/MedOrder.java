package ru.mospolytech.therapy_cabinet.models.domain.order;

import lombok.Data;
import org.joda.time.DateTime;

import java.util.UUID;

@Data
public class MedOrder {

    /**
     * Идентификатор заказа
     */
    private UUID id;

    /**
     * Наименование поставщика (аптеки)
     */
    private String supplier;

    /**
     * Дата создания заказа
     */
    private DateTime formDate;

    /**
     * Дата ожидаемого получения заказа
     */
    private DateTime deliveryDate;

    /**
     * Статус заказа
     */
    private MedOrderStatus status;

}
