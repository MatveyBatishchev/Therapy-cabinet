package ru.mospolytech.therapy_cabinet.controller.lab_type;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.mospolytech.therapy_cabinet.models.domain.LabType;
import ru.mospolytech.therapy_cabinet.service.lab_type.LabTypeServiceImpl;

import java.util.List;

@RestController
@AllArgsConstructor
public class LabTypeControllerImpl implements LabTypeController {

    private final LabTypeServiceImpl labTypeService;

    @Override
    public LabType create(LabType labType) {
        return labTypeService.createLabType(labType);
    }

    @Override
    public LabType read(int id) {
        return labTypeService.findLabTypeById(id);
    }

    @Override
    public void update(LabType labType) {
        labTypeService.updateLabType(labType);
    }

    @Override
    public void delete(int id) {
        labTypeService.deleteLabType(id);
    }

    @Override
    public List<LabType> readAll(Long offset, Long limit) {
        return labTypeService.findAllLabTypes(offset, limit);
    }
}
