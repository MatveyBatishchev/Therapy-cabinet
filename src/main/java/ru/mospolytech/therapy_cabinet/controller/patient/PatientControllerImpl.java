package ru.mospolytech.therapy_cabinet.controller.patient;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.mospolytech.therapy_cabinet.models.domain.Patient;
import ru.mospolytech.therapy_cabinet.service.patient.PatientServiceImpl;

import java.util.List;

//TODO: add sql exception propagation
@RestController
@AllArgsConstructor
public class PatientControllerImpl implements PatientController {

    private final PatientServiceImpl patientService;

    @Override
    public Patient create(Patient patient) {
        return patientService.createPatent(patient);
    }

    @Override
    public Patient read(Integer id) {
        return patientService.findPatientById(id);
    }

    @Override
    public void update(Patient patient) {
        patientService.updatePatient(patient);
    }

    @Override
    public void delete(Integer id) {
        patientService.deletePatient(id);
    }

    @Override
    public List<Patient> readAll(Long offset, Long limit) {
        return patientService.findAllPatients(offset, limit);
    }

    @Override
    public void addPatientIcd(Integer id, String icdCode) {
        patientService.addPatientIcd(id, icdCode);
    }

    @Override
    public List<String> readPatientIcds(Integer id) {
        return patientService.findPatientIcds(id);
    }

    @Override
    public void removePatientIcd(Integer id, String icdCode) {
        patientService.removePatientIcd(id, icdCode);
    }
}
