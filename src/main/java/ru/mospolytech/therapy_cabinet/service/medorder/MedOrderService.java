package ru.mospolytech.therapy_cabinet.service.medorder;

import ru.mospolytech.therapy_cabinet.models.domain.order.MedOrder;

import java.util.List;

public interface MedOrderService {

    void createMedOrder(MedOrder medOrder);

    MedOrder findMedOrderById(Integer id);

    void updateMedOrder(MedOrder medOrder);

    void deleteMedOrder(Integer id);

    List<MedOrder> findAllMedOrders(Long offset, Long limit);


}
