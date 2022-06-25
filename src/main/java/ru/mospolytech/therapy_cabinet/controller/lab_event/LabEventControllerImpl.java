package ru.mospolytech.therapy_cabinet.controller.lab_event;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.mospolytech.therapy_cabinet.models.domain.labevent.LabEventCreate;
import ru.mospolytech.therapy_cabinet.models.domain.labevent.LabEventRead;
import ru.mospolytech.therapy_cabinet.service.lab_event.LabEventServiceImpl;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class LabEventControllerImpl implements LabEventController {

    private final LabEventServiceImpl labEventService;

    @Override
    public void create(LabEventCreate labEvent) {
        labEventService.createLabEvent(labEvent);
    }

    @Override
    public LabEventRead read(UUID id) {
        return labEventService.findLabEventById(id);
    }

    @Override
    public void update(UUID id, LabEventCreate labEvent) {
        labEventService.updateLabEvent(id, labEvent);
    }

    @Override
    public void delete(UUID id) {
        labEventService.deleteLabEvent(id);
    }

    @Override
    public List<LabEventRead> readAll(Long offset, Long limit) {
        return labEventService.findAllLabEvents(offset, limit);
    }

}
