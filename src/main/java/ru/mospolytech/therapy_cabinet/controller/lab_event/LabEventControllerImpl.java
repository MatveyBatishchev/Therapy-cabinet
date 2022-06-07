package ru.mospolytech.therapy_cabinet.controller.lab_event;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ru.mospolytech.therapy_cabinet.models.domain.LabEventCreate;
import ru.mospolytech.therapy_cabinet.models.domain.LabEventRead;
import ru.mospolytech.therapy_cabinet.mybatis.mappers.LabEventMapper;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LabEventControllerImpl implements LabEventController {
    private final LabEventMapper labEventMapper;

    @Override
    public void create(LabEventCreate labEvent) {
        labEvent.setId(UUID.randomUUID());
        labEventMapper.create(labEvent);
    }

    @Override
    public LabEventRead read(UUID id) {
        return labEventMapper.read(id);
    }

    @Override
    public void update(UUID id, LabEventCreate labEvent) {
        labEventMapper.update(id, labEvent);
    }

    @Override
    public void delete(UUID id) {
        labEventMapper.delete(id);
    }

    @Override
    public List<LabEventRead> readAll(Long offset, Long limit) {
        return labEventMapper.readAll(offset, limit);
    }
}
