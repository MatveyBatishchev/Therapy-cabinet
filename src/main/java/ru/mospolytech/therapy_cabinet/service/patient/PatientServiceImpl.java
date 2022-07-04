package ru.mospolytech.therapy_cabinet.service.patient;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mospolytech.therapy_cabinet.models.domain.Patient;
import ru.mospolytech.therapy_cabinet.mybatis.mappers.PatientMapper;

import java.util.List;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientMapper patientMapper;

    @Override
    public Patient createPatent(Patient patient) {
        patientMapper.create(patient);
        return patient;
    }

    @Override
    public Patient findPatientById(Integer id) {
        return patientMapper.read(id);
    }

    @Override
    public void updatePatient(Patient patient) {
        patientMapper.update(patient);
    }

    @Override
    public void deletePatient(Integer id) {
        patientMapper.delete(id);
    }

    @Override
    public List<Patient> findAllPatients(Long offset, Long limit) {
        return patientMapper.readAll(offset, limit);
    }

    @Override
    public void addPatientIcd(Integer id, String icdCode) {
        patientMapper.addPatientIcd(id, icdCode);
    }

    @Override
    public List<String> findPatientIcds(Integer id) {
        return patientMapper.readPatientIcds(id);
    }

    @Override
    public void removePatientIcd(Integer id, String icdCode) {
        patientMapper.removePatientIcd(id, icdCode);
    }

}
