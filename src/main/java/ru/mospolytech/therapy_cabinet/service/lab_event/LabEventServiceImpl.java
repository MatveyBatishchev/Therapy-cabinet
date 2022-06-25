package ru.mospolytech.therapy_cabinet.service.lab_event;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mospolytech.therapy_cabinet.models.domain.labevent.LabEventCreate;
import ru.mospolytech.therapy_cabinet.models.domain.labevent.LabEventRead;
import ru.mospolytech.therapy_cabinet.mybatis.mappers.LabEventMapper;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class LabEventServiceImpl implements LabEventService {

    private final LabEventMapper labEventMapper;

    @Override
    public void createLabEvent(LabEventCreate labEvent) {
        labEvent.setId(UUID.randomUUID());
        labEventMapper.create(labEvent);
    }

    @Override
    public LabEventRead findLabEventById(UUID id) {
        return labEventMapper.read(id);
    }

    @Override
    public void updateLabEvent(UUID id, LabEventCreate labEvent) {
        labEventMapper.update(id, labEvent);
    }

    @Override
    public void deleteLabEvent(UUID id) {
        labEventMapper.delete(id);
    }

    @Override
    public List<LabEventRead> findAllLabEvents(Long offset, Long limit) {
        return labEventMapper.readAll(offset, limit);
    }

}
