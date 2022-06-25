package ru.mospolytech.therapy_cabinet.service.medication;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mospolytech.therapy_cabinet.models.domain.Medication;
import ru.mospolytech.therapy_cabinet.mybatis.mappers.MedicationMapper;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MedicationServiceImpl implements MedicationService {

    private final MedicationMapper medicationMapper;

    @Override
    public void createMedication(Medication medication) {
        medication.setId(UUID.randomUUID());
        medicationMapper.create(medication);
    }

    @Override
    public Medication findMedicationById(UUID id) {
        return medicationMapper.read(id);
    }

    @Override
    public void updateMedication(Medication medication) {
        medicationMapper.update(medication);
    }

    @Override
    public void deleteMedication(UUID id) {
        medicationMapper.delete(id);
    }

    @Override
    public List<Medication> findAllMedications(Long offset, Long limit) {
        return medicationMapper.readAll(offset, limit);
    }

}
