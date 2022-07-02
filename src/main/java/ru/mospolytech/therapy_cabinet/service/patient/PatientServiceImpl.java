package ru.mospolytech.therapy_cabinet.service.patient;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mospolytech.therapy_cabinet.models.domain.Patient;
import ru.mospolytech.therapy_cabinet.mybatis.mappers.PatientMapper;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientMapper patientMapper;

    @Override
    public Patient createPatent(Patient patient) {
        patient.setId(UUID.randomUUID());
        patientMapper.create(patient);
        return patient;
    }

    @Override
    public Patient findPatientById(UUID id) {
        return patientMapper.read(id);
    }

    @Override
    public void updatePatient(Patient patient) {
        patientMapper.update(patient);
    }

    @Override
    public void deletePatient(UUID id) {
        patientMapper.delete(id);
    }

    @Override
    public List<Patient> findAllPatients(Long offset, Long limit) {
        return patientMapper.readAll(offset, limit);
    }

    @Override
    public void addPatientIcd(UUID id, String icdCode) {
        patientMapper.addPatientIcd(id, icdCode);
    }

    @Override
    public List<String> findPatientIcds(UUID id) {
        return patientMapper.readPatientIcds(id);
    }

    @Override
    public void removePatientIcd(UUID id, String icdCode) {
        patientMapper.removePatientIcd(id, icdCode);
    }

}
