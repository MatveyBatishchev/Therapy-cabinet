package ru.mospolytech.therapy_room.controller.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ru.mospolytech.therapy_room.models.domain.Patient;
import ru.mospolytech.therapy_room.mybatis.mappers.PatientMapper;

import java.util.List;
import java.util.UUID;

@RestController
public class PatientControllerImpl implements PatientController {

    private final PatientMapper patientMapper;

    @Autowired
    public PatientControllerImpl(final PatientMapper patientMapper) {
        this.patientMapper = patientMapper;
    }

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
}
