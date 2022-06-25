package ru.mospolytech.therapy_cabinet.service.order_entry;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mospolytech.therapy_cabinet.models.domain.order.OrderEntryCreate;
import ru.mospolytech.therapy_cabinet.models.domain.order.OrderEntryRead;
import ru.mospolytech.therapy_cabinet.mybatis.mappers.OrderEntryMapper;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderEntryServiceImpl implements OrderEntryService {

    private final OrderEntryMapper orderEntryMapper;

    @Override
    public void createOrderEntry(OrderEntryCreate orderEntry) {
        orderEntryMapper.create(orderEntry);
    }

    @Override
    public OrderEntryRead findOrderEntryById(int id) {
        return orderEntryMapper.read(id);
    }

    @Override
    public void updateOrderEntry(int id, OrderEntryCreate orderEntry) {
        orderEntryMapper.update(id, orderEntry);
    }

    @Override
    public void deleteOrderEntry(int id) {
        orderEntryMapper.delete(id);
    }

    @Override
    public List<OrderEntryRead> findAllOrderEntries(Long offset, Long limit) {
        return orderEntryMapper.readAll(offset, limit);
    }
}
