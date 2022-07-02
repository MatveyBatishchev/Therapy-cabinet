package ru.mospolytech.therapy_cabinet.service.lab_event;

import ru.mospolytech.therapy_cabinet.models.domain.labevent.LabEventCreate;
import ru.mospolytech.therapy_cabinet.models.domain.labevent.LabEventRead;

import java.util.List;
import java.util.UUID;

public interface LabEventService {

    void createLabEvent(LabEventCreate labEvent);

    LabEventRead findLabEventById(UUID id);

    void updateLabEvent(UUID id, LabEventCreate labEvent);

    void deleteLabEvent(UUID id);

    List<LabEventRead> findAllLabEvents(Long offset, Long limit);

}
