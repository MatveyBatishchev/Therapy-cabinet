package ru.mospolytech.therapy_cabinet.controller.therapy;

import lombok.AllArgsConstructor;
import org.joda.time.LocalDate;
import org.springframework.web.bind.annotation.RestController;
import ru.mospolytech.therapy_cabinet.models.domain.prescription.PrescriptionCreate;
import ru.mospolytech.therapy_cabinet.models.domain.prescription.PrescriptionRead;
import ru.mospolytech.therapy_cabinet.models.domain.therapy.TherapyCreate;
import ru.mospolytech.therapy_cabinet.models.domain.therapy.TherapyRead;
import ru.mospolytech.therapy_cabinet.mybatis.mappers.PrescriptionMapper;
import ru.mospolytech.therapy_cabinet.mybatis.mappers.TherapyMapper;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class TherapyControllerImpl implements TherapyController{

    private final TherapyMapper therapyMapper;
    private final PrescriptionMapper prescriptionMapper;

    @Override
    public void create(TherapyCreate therapy) {
        therapyMapper.create(therapy);
    }

    @Override
    public TherapyRead read(int id) {
        return therapyMapper.read(id);
    }

    @Override
    public void update(int id, TherapyCreate therapy) {
        therapyMapper.update(id, therapy);
    }

    @Override
    public void delete(int id) {
        therapyMapper.delete(id);
    }

    @Override
    public List<TherapyCreate> readAll(Long offset, Long limit) {
        return therapyMapper.readAll(offset, limit);
    }

    @Override
    public List<TherapyCreate> readAllByPatientId(UUID patientId, LocalDate startDate, LocalDate endDate) {
        return therapyMapper.readAllByPatientId(patientId, startDate, endDate);
    }

    @Override
    public void createPrescription(int therapyId, PrescriptionCreate prescription) {
        prescription.setTherapyId(therapyId);
        prescription.setId(UUID.randomUUID());
        prescriptionMapper.create(prescription);
    }

    @Override
    public PrescriptionRead readPrescription(int therapyId) {
        return prescriptionMapper.readByTherapyId(therapyId);
    }

    @Override
    public void updatePrescription(int therapyId, PrescriptionCreate prescription) {
        prescriptionMapper.updateByTherapyId(therapyId, prescription);
    }

    @Override
    public void deletePrescription(int therapyId) {
        prescriptionMapper.deleteByTherapyId(therapyId);
    }

    @Override
    public List<PrescriptionCreate> readAllPrescriptions(Long offset, Long limit) {
        return prescriptionMapper.readAll(offset, limit);
    }

}
