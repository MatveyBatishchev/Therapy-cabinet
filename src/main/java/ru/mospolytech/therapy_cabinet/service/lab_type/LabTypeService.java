package ru.mospolytech.therapy_cabinet.service.lab_type;

import ru.mospolytech.therapy_cabinet.models.domain.LabType;

import java.util.List;

public interface LabTypeService {

    LabType createLabType(LabType labType);

    LabType findLabTypeById(int id);

    void updateLabType(LabType labType);

    void deleteLabType(int id);

    List<LabType> findAllLabTypes(Long offset, Long limit);

}
