package ru.mospolytech.therapy_cabinet.service.prescription;

import ru.mospolytech.therapy_cabinet.models.domain.prescription.AdministrationType;
import ru.mospolytech.therapy_cabinet.models.domain.prescription.PrescriptionCreate;
import ru.mospolytech.therapy_cabinet.models.domain.prescription.PrescriptionRead;

import java.util.List;
import java.util.UUID;

public interface PrescriptionService {

    void createPrescription(PrescriptionCreate prescription);

    PrescriptionRead findPrescriptionById(UUID id);

    void updatePrescription(UUID id, PrescriptionCreate prescription);

    void deletePrescription(UUID id);

    List<PrescriptionCreate> findAllPrescriptions(Long offset, Long limit);

    PrescriptionRead findPrescriptionByTherapyId(int therapyId);

    List<PrescriptionCreate> findPrescriptionsBySearch(UUID medicationId, Integer doseAmount, Double substanceAmount,
                                                       AdministrationType administrationType);

}
