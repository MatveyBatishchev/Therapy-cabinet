package ru.mospolytech.therapy_cabinet.service.lab_type;

import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import ru.mospolytech.therapy_cabinet.models.domain.LabType;
import ru.mospolytech.therapy_cabinet.mybatis.mappers.LabTypeMapper;

import java.util.List;

@Service
@AllArgsConstructor
public class LabTypeServiceImpl implements LabTypeService {

    private final LabTypeMapper labTypeMapper;

    @Override
    public LabType createLabType(LabType labType) {
        val generatedId = labTypeMapper.create(labType);
        labType.setId(generatedId);
        return labType;
    }

    @Override
    public LabType findLabTypeById(int id) {
        return labTypeMapper.read(id);
    }

    @Override
    public void updateLabType(LabType labType) {
        labTypeMapper.update(labType);
    }

    @Override
    public void deleteLabType(int id) {
        labTypeMapper.delete(id);
    }

    @Override
    public List<LabType> findAllLabTypes(Long offset, Long limit) {
        return labTypeMapper.readAll(offset, limit);
    }
}
