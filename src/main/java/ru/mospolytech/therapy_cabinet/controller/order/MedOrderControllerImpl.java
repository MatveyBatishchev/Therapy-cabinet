package ru.mospolytech.therapy_cabinet.controller.order;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.mospolytech.therapy_cabinet.models.domain.order.MedOrder;
import ru.mospolytech.therapy_cabinet.service.medorder.MedOrderServiceImpl;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class MedOrderControllerImpl implements MedOrderController {

    private final MedOrderServiceImpl medOrderService;

    @Override
    public void create(MedOrder medOrder) {
        medOrderService.createMedOrder(medOrder);
    }

    @Override
    public MedOrder read(UUID id) {
        return medOrderService.findMedOrderById(id);
    }

    @Override
    public void update(MedOrder medOrder) {
        medOrderService.updateMedOrder(medOrder);
    }

    @Override
    public void delete(UUID id) {
        medOrderService.deleteMedOrder(id);
    }

    @Override
    public List<MedOrder> readAll(Long offset, Long limit) {
        return medOrderService.findAllMedOrders(offset, limit);
    }

}
