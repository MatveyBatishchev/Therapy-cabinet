package ru.mospolytech.therapy_cabinet.controller.prescription;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.mospolytech.therapy_cabinet.models.domain.prescription.PrescriptionCreate;
import ru.mospolytech.therapy_cabinet.models.domain.prescription.PrescriptionRead;
import ru.mospolytech.therapy_cabinet.mybatis.mappers.PrescriptionMapper;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class PrescriptionControllerImpl implements PrescriptionController {

    private final PrescriptionMapper prescriptionMapper;

    @Override
    public void create(PrescriptionCreate prescription) {
        prescription.setId(UUID.randomUUID());
        prescriptionMapper.create(prescription);
    }

    @Override
    public PrescriptionRead read(UUID id) {
        return prescriptionMapper.read(id);
    }

    @Override
    public void update(UUID id, PrescriptionCreate prescription) {
        prescriptionMapper.update(id, prescription);
    }

    @Override
    public void delete(UUID id) {
        prescriptionMapper.delete(id);
    }

    @Override
    public List<PrescriptionRead> readAll(Long offset, Long limit) {
        return prescriptionMapper.readAll(offset, limit);
    }

}
