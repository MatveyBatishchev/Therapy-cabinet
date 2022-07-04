package ru.mospolytech.therapy_cabinet.service.lab_event;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mospolytech.therapy_cabinet.models.domain.labevent.LabEventCreate;
import ru.mospolytech.therapy_cabinet.models.domain.labevent.LabEventRead;
import ru.mospolytech.therapy_cabinet.mybatis.mappers.LabEventMapper;

import java.util.List;

@Service
@AllArgsConstructor
public class LabEventServiceImpl implements LabEventService {

    private final LabEventMapper labEventMapper;

    @Override
    public void createLabEvent(LabEventCreate labEvent) {
        labEventMapper.create(labEvent);
    }

    @Override
    public LabEventRead findLabEventById(Integer id) {
        return labEventMapper.read(id);
    }

    @Override
    public void updateLabEvent(Integer id, LabEventCreate labEvent) {
        labEventMapper.update(id, labEvent);
    }

    @Override
    public void deleteLabEvent(Integer id) {
        labEventMapper.delete(id);
    }

    @Override
    public List<LabEventRead> findAllLabEvents(Long offset, Long limit) {
        return labEventMapper.readAll(offset, limit);
    }

}
