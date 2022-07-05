package ru.mospolytech.therapy_cabinet.controller.medication;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.mospolytech.therapy_cabinet.models.domain.Medication;
import ru.mospolytech.therapy_cabinet.service.medication.MedicationServiceImpl;

import java.util.List;


@RestController
@AllArgsConstructor
public class MedicationControllerImpl implements MedicationController {

    private final MedicationServiceImpl medicationService;

    @Override
    public void create(Medication medication) {
        medicationService.createMedication(medication);
    }

    @Override
    public Medication read(Integer id) {
        return medicationService.findMedicationById(id);
    }

    @Override
    public void update(Medication medication) {
        medicationService.updateMedication(medication);
    }

    @Override
    public void delete(Integer id) {
        medicationService.deleteMedication(id);
    }

    @Override
    public List<Medication> readAll(Long offset, Long limit) {
        return medicationService.findAllMedications(offset, limit);
    }
}
