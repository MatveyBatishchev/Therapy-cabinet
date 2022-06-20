package ru.mospolytech.therapy_cabinet.controller.order;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.mospolytech.therapy_cabinet.models.domain.order.MedOrder;
import ru.mospolytech.therapy_cabinet.mybatis.mappers.MedOrderMapper;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class MedOrderControllerImpl implements MedOrderController {

    private final MedOrderMapper medOrderMapper;

    @Override
    public void create(MedOrder medOrder) {
        medOrder.setId(UUID.randomUUID());
        medOrderMapper.create(medOrder);
    }

    @Override
    public MedOrder read(UUID id) {
        return medOrderMapper.read(id);
    }

    @Override
    public void update(MedOrder medOrder) {
        medOrderMapper.update(medOrder);
    }

    @Override
    public void delete(UUID id) {
        medOrderMapper.delete(id);
    }

    @Override
    public List<MedOrder> readAll(Long offset, Long limit) {
        return medOrderMapper.readAll(offset, limit);
    }

}
