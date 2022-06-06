package ru.mospolytech.therapy_cabinet.controller.lab_type;

import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ru.mospolytech.therapy_cabinet.models.domain.LabType;
import ru.mospolytech.therapy_cabinet.mybatis.mappers.LabEventMapper;
import ru.mospolytech.therapy_cabinet.mybatis.mappers.LabTypeMapper;

import java.util.List;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LabTypeControllerImpl implements LabTypeController {
    private final LabTypeMapper labTypeMapper;

    @Override
    public LabType create(LabType labType) {
        val generatedId = labTypeMapper.create(labType);
        labType.setId(generatedId);
        return labType;
    }

    @Override
    public LabType read(int id) {
        return labTypeMapper.read(id);
    }

    @Override
    public void update(LabType labType) {
        labTypeMapper.update(labType);
    }

    @Override
    public void delete(int id) {
        labTypeMapper.delete(id);
    }

    @Override
    public List<LabType> readAll(Long offset, Long limit) {
        return labTypeMapper.readAll(offset, limit);
    }
}
