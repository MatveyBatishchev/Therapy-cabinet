package ru.mospolytech.therapy_cabinet.service.prescription;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mospolytech.therapy_cabinet.models.domain.prescription.AdministrationType;
import ru.mospolytech.therapy_cabinet.models.domain.prescription.PrescriptionCreate;
import ru.mospolytech.therapy_cabinet.models.domain.prescription.PrescriptionRead;
import ru.mospolytech.therapy_cabinet.mybatis.mappers.PrescriptionMapper;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PrescriptionServiceImpl implements PrescriptionService {

    private final PrescriptionMapper prescriptionMapper;

    @Override
    public void createPrescription(PrescriptionCreate prescription) {
        prescription.setId(UUID.randomUUID());
        System.out.println(prescription);
        prescriptionMapper.create(prescription);
    }

    @Override
    public PrescriptionRead findPrescriptionById(UUID id) {
        return prescriptionMapper.read(id);
    }

    @Override
    public void updatePrescription(UUID id, PrescriptionCreate prescription) {
        prescriptionMapper.update(id, prescription);
    }

    @Override
    public void deletePrescription(UUID id) {
        prescriptionMapper.delete(id);
    }

    @Override
    public List<PrescriptionCreate> findAllPrescriptions(Long offset, Long limit) {
        return prescriptionMapper.readAll(offset, limit);
    }

    @Override
    public PrescriptionRead findPrescriptionByTherapyId(int therapyId) {
        return prescriptionMapper.readByTherapyId(therapyId);
    }

    @Override
    public List<PrescriptionCreate> findPrescriptionsBySearch(UUID medicationId, Integer doseAmount, Double substanceAmount,
                                                              AdministrationType administrationType) {
        return prescriptionMapper.readAllBySearch(medicationId, doseAmount, substanceAmount, administrationType);
    }
}
