package ru.mospolytech.therapy_cabinet.controller.prescription;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.mospolytech.therapy_cabinet.models.domain.prescription.AdministrationType;
import ru.mospolytech.therapy_cabinet.models.domain.prescription.PrescriptionCreate;
import ru.mospolytech.therapy_cabinet.models.domain.prescription.PrescriptionRead;
import ru.mospolytech.therapy_cabinet.service.prescription.PrescriptionServiceImpl;

import java.util.List;


@RestController
@AllArgsConstructor
public class PrescriptionControllerImpl implements PrescriptionController {

    private final PrescriptionServiceImpl prescriptionService;

    @Override
    public void create(PrescriptionCreate prescription) {
        prescriptionService.createPrescription(prescription);
    }

    @Override
    public PrescriptionRead read(Integer id) {
        return prescriptionService.findPrescriptionById(id);
    }

    @Override
    public void update(Integer id, PrescriptionCreate prescription) {
        prescriptionService.updatePrescription(id, prescription);
    }

    @Override
    public void delete(Integer id) {
        prescriptionService.deletePrescription(id);
    }

    @Override
    public List<PrescriptionCreate> readAll(Long offset, Long limit) {
        return prescriptionService.findAllPrescriptions(offset, limit);
    }

    @Override
    public PrescriptionRead readByTherapyId(int therapyId) {
        return prescriptionService.findPrescriptionByTherapyId(therapyId);
    }

    @Override
    public List<PrescriptionCreate> readAllBySearch(Integer medicationId, Integer doseAmount, Double substanceAmount,
                                                    AdministrationType administrationType) {
        return prescriptionService.findPrescriptionsBySearch(medicationId, doseAmount, substanceAmount, administrationType);
    }
}
