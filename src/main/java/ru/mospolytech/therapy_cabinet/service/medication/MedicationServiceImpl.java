package ru.mospolytech.therapy_cabinet.service.medication;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mospolytech.therapy_cabinet.models.domain.Medication;
import ru.mospolytech.therapy_cabinet.mybatis.mappers.MedicationMapper;

import java.util.List;

@Service
@AllArgsConstructor
public class MedicationServiceImpl implements MedicationService {

    private final MedicationMapper medicationMapper;

    @Override
    public void createMedication(Medication medication) {
        medicationMapper.create(medication);
    }

    @Override
    public Medication findMedicationById(Integer id) {
        return medicationMapper.read(id);
    }

    @Override
    public void updateMedication(Medication medication) {
        medicationMapper.update(medication);
    }

    @Override
    public void deleteMedication(Integer id) {
        medicationMapper.delete(id);
    }

    @Override
    public List<Medication> findAllMedications(Long offset, Long limit) {
        return medicationMapper.readAll(offset, limit);
    }

}
