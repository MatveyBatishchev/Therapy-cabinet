package ru.mospolytech.therapy_cabinet.controller.order_entry;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.mospolytech.therapy_cabinet.models.domain.order.OrderEntryCreate;
import ru.mospolytech.therapy_cabinet.models.domain.order.OrderEntryRead;
import ru.mospolytech.therapy_cabinet.service.order_entry.OrderEntryServiceImpl;

import java.util.List;

@RestController
@AllArgsConstructor
public class OrderEntryControllerImpl implements OrderEntryController {

    private final OrderEntryServiceImpl orderEntryService;

    @Override
    public void create(OrderEntryCreate orderEntry) {
        orderEntryService.createOrderEntry(orderEntry);
    }

    @Override
    public OrderEntryRead read(int id) {
        return orderEntryService.findOrderEntryById(id);
    }

    @Override
    public void update(int id, OrderEntryCreate orderEntry) {
        orderEntryService.updateOrderEntry(id, orderEntry);
    }

    @Override
    public void delete(int id) {
        orderEntryService.deleteOrderEntry(id);
    }

    @Override
    public List<OrderEntryRead> readAll(Long offset, Long limit) {
        return orderEntryService.findAllOrderEntries(offset, limit);
    }
}
