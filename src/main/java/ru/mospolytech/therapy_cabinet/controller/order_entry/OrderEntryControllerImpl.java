package ru.mospolytech.therapy_cabinet.controller.order_entry;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.mospolytech.therapy_cabinet.models.domain.order.OrderEntryCreate;
import ru.mospolytech.therapy_cabinet.models.domain.order.OrderEntryRead;
import ru.mospolytech.therapy_cabinet.mybatis.mappers.OrderEntryMapper;

import java.util.List;

@RestController
@AllArgsConstructor
public class OrderEntryControllerImpl implements OrderEntryController {

    private final OrderEntryMapper orderEntryMapper;

    @Override
    public void create(OrderEntryCreate orderEntry) {
        orderEntryMapper.create(orderEntry);
    }

    @Override
    public OrderEntryRead read(int id) {
        return orderEntryMapper.read(id);
    }

    @Override
    public void update(int id, OrderEntryCreate orderEntry) {
        orderEntryMapper.update(id, orderEntry);
    }

    @Override
    public void delete(int id) {
        orderEntryMapper.delete(id);
    }

    @Override
    public List<OrderEntryRead> readAll(Long offset, Long limit) {
        return orderEntryMapper.readAll(offset, limit);
    }

}
