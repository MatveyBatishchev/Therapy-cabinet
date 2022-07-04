package ru.mospolytech.therapy_cabinet.service.medication;

import ru.mospolytech.therapy_cabinet.models.domain.Medication;

import java.util.List;

public interface MedicationService {

    void createMedication(Medication medication);

    Medication findMedicationById(Integer id);

    void updateMedication(Medication medication);

    void deleteMedication(Integer id);

    List<Medication> findAllMedications(Long offset, Long limit);

}
