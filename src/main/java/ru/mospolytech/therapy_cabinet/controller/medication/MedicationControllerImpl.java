package ru.mospolytech.therapy_cabinet.controller.medication;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.mospolytech.therapy_cabinet.models.domain.Medication;
import ru.mospolytech.therapy_cabinet.mybatis.mappers.MedicationMapper;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class MedicationControllerImpl implements MedicationController {

    private final MedicationMapper medicationMapper;

    @Override
    public void create(Medication medication) {
        medication.setId(UUID.randomUUID());
        medicationMapper.create(medication);
    }

    @Override
    public Medication read(UUID id) {
        return medicationMapper.read(id);
    }

    @Override
    public void update(Medication medication) {
        medicationMapper.update(medication);
    }

    @Override
    public void delete(UUID id) {
        medicationMapper.delete(id);
    }

    @Override
    public List<Medication> readAll(Long offset, Long limit) {
        return medicationMapper.readAll(offset, limit);
    }

}
