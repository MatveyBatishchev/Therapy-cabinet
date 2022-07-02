package ru.mospolytech.therapy_cabinet.service.medication;

import ru.mospolytech.therapy_cabinet.models.domain.Medication;

import java.util.List;
import java.util.UUID;

public interface MedicationService {

    void createMedication(Medication medication);

    Medication findMedicationById(UUID id);

    void updateMedication(Medication medication);

    void deleteMedication(UUID id);

    List<Medication> findAllMedications(Long offset, Long limit);

}
