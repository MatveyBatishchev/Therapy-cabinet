package ru.mospolytech.therapy_cabinet.service.patient;

import ru.mospolytech.therapy_cabinet.models.domain.Patient;

import java.util.List;

public interface PatientService {

    Patient createPatent(Patient patient);

    Patient findPatientById(Integer id);

    void updatePatient(Patient patient);

    void deletePatient(Integer id);

    List<Patient> findAllPatients(Long offset, Long limit);

    void addPatientIcd(Integer id, String icdCode);

    List<String> findPatientIcds(Integer id);

    void removePatientIcd(Integer id, String icdCode);
}
