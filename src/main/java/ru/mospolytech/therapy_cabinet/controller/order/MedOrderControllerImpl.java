package ru.mospolytech.therapy_cabinet.controller.order;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.mospolytech.therapy_cabinet.models.domain.order.MedOrder;
import ru.mospolytech.therapy_cabinet.service.medorder.MedOrderServiceImpl;

import java.util.List;


@RestController
@AllArgsConstructor
public class MedOrderControllerImpl implements MedOrderController {

    private final MedOrderServiceImpl medOrderService;

    @Override
    public void create(MedOrder medOrder) {
        medOrderService.createMedOrder(medOrder);
    }

    @Override
    public MedOrder read(Integer id) {
        return medOrderService.findMedOrderById(id);
    }

    @Override
    public void update(MedOrder medOrder) {
        medOrderService.updateMedOrder(medOrder);
    }

    @Override
    public void delete(Integer id) {
        medOrderService.deleteMedOrder(id);
    }

    @Override
    public List<MedOrder> readAll(Long offset, Long limit) {
        return medOrderService.findAllMedOrders(offset, limit);
    }
}
