package ru.mospolytech.therapy_cabinet.service.medorder;

import ru.mospolytech.therapy_cabinet.models.domain.order.MedOrder;

import java.util.List;
import java.util.UUID;

public interface MedOrderService {

    void createMedOrder(MedOrder medOrder);

    MedOrder findMedOrderById(UUID id);

    void updateMedOrder(MedOrder medOrder);

    void deleteMedOrder(UUID id);

    List<MedOrder> findAllMedOrders(Long offset, Long limit);


}
