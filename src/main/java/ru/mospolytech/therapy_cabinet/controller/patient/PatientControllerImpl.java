package ru.mospolytech.therapy_cabinet.controller.patient;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.ibatis.reflection.ArrayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ru.mospolytech.therapy_cabinet.models.domain.Patient;
import ru.mospolytech.therapy_cabinet.mybatis.mappers.PatientMapper;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

//TODO: add sql exception propagation
@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PatientControllerImpl implements PatientController {
    private final PatientMapper patientMapper;

    @Override
    public Patient create(Patient patient) {
        patient.setId(UUID.randomUUID());
        patientMapper.create(patient);
        return patient;
    }

    @Override
    public Patient read(UUID id) {
        return patientMapper.read(id);
    }

    @Override
    public void update(Patient patient) {
        patientMapper.update(patient);
    }

    @Override
    public void delete(UUID id) {
        patientMapper.delete(id);
    }

    @Override
    public List<Patient> readAll(Long offset, Long limit) {
        return patientMapper.readAll(offset, limit);
    }

    @Override
    public void addPatientIcd(UUID id, String icdCode) {
        patientMapper.addPatientIcd(id, icdCode);
    }

    @Override
    public List<String> readPatientIcds(UUID id) {
        return patientMapper.readPatientIcds(id);
    }

    @Override
    public void removePatientIcd(UUID id, String icdCode) {
        patientMapper.removePatientIcd(id, icdCode);
    }
}
