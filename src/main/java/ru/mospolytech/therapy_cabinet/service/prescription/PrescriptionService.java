package ru.mospolytech.therapy_cabinet.service.prescription;

import ru.mospolytech.therapy_cabinet.models.domain.prescription.AdministrationType;
import ru.mospolytech.therapy_cabinet.models.domain.prescription.PrescriptionCreate;
import ru.mospolytech.therapy_cabinet.models.domain.prescription.PrescriptionRead;

import java.util.List;

public interface PrescriptionService {

    void createPrescription(PrescriptionCreate prescription);

    PrescriptionRead findPrescriptionById(Integer id);

    void updatePrescription(Integer id, PrescriptionCreate prescription);

    void deletePrescription(Integer id);

    List<PrescriptionCreate> findAllPrescriptions(Long offset, Long limit);

    PrescriptionRead findPrescriptionByTherapyId(int therapyId);

    List<PrescriptionCreate> findPrescriptionsBySearch(Integer medicationId, Integer doseAmount, Double substanceAmount,
                                                       AdministrationType administrationType);

}
