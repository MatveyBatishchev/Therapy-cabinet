package ru.mospolytech.therapy_cabinet.service.lab_event;

import ru.mospolytech.therapy_cabinet.models.domain.labevent.LabEventCreate;
import ru.mospolytech.therapy_cabinet.models.domain.labevent.LabEventRead;

import java.util.List;

public interface LabEventService {

    void createLabEvent(LabEventCreate labEvent);

    LabEventRead findLabEventById(Integer id);

    void updateLabEvent(Integer id, LabEventCreate labEvent);

    void deleteLabEvent(Integer id);

    List<LabEventRead> findAllLabEvents(Long offset, Long limit);

}
