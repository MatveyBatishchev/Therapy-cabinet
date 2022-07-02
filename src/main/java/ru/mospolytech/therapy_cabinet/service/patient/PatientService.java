package ru.mospolytech.therapy_cabinet.service.patient;

import ru.mospolytech.therapy_cabinet.models.domain.Patient;

import java.util.List;
import java.util.UUID;

public interface PatientService {

    Patient createPatent(Patient patient);

    Patient findPatientById(UUID id);

    void updatePatient(Patient patient);

    void deletePatient(UUID id);

    List<Patient> findAllPatients(Long offset, Long limit);

    void addPatientIcd(UUID id, String icdCode);

    List<String> findPatientIcds(UUID id);

    void removePatientIcd(UUID id, String icdCode);

}
