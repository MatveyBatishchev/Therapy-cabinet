package ru.mospolytech.therapy_cabinet.service.medorder;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mospolytech.therapy_cabinet.models.domain.order.MedOrder;
import ru.mospolytech.therapy_cabinet.mybatis.mappers.MedOrderMapper;

import java.util.List;

@Service
@AllArgsConstructor
public class MedOrderServiceImpl implements MedOrderService {

    private final MedOrderMapper medOrderMapper;

    @Override
    public void createMedOrder(MedOrder medOrder) {
        medOrderMapper.create(medOrder);
    }

    @Override
    public MedOrder findMedOrderById(Integer id) {
        return medOrderMapper.read(id);
    }

    @Override
    public void updateMedOrder(MedOrder medOrder) {
        medOrderMapper.update(medOrder);
    }

    @Override
    public void deleteMedOrder(Integer id) {
        medOrderMapper.delete(id);
    }

    @Override
    public List<MedOrder> findAllMedOrders(Long offset, Long limit) {
        return medOrderMapper.readAll(offset, limit);
    }
}
