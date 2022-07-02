package ru.mospolytech.therapy_cabinet.service.order_entry;

import ru.mospolytech.therapy_cabinet.models.domain.order.OrderEntryCreate;
import ru.mospolytech.therapy_cabinet.models.domain.order.OrderEntryRead;

import java.util.List;

public interface OrderEntryService {

    void createOrderEntry(OrderEntryCreate orderEntry);

    OrderEntryRead findOrderEntryById(int id);

    void updateOrderEntry(int id, OrderEntryCreate orderEntry);

    void deleteOrderEntry(int id);

    List<OrderEntryRead> findAllOrderEntries(Long offset, Long limit);

}
