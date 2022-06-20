package ru.mospolytech.therapy_cabinet.models.domain.order;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.mospolytech.therapy_cabinet.models.domain.Medication;

@Data
@EqualsAndHashCode(callSuper = true)
public class OrderEntryRead extends OrderEntry {

    /**
     * Объект лекарственного препарата в записи заказа
     */
    private Medication medication;

    /**
     * Объект заказа, к которому прикреплена запись
     */
    private MedOrder medOrder;

}
