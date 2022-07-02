package ru.mospolytech.therapy_cabinet.controller.med_index;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.mospolytech.therapy_cabinet.models.domain.IndexType;
import ru.mospolytech.therapy_cabinet.models.domain.medindex.MedIndexCreate;
import ru.mospolytech.therapy_cabinet.models.domain.medindex.MedIndexRead;
import ru.mospolytech.therapy_cabinet.mybatis.mappers.MedIndexMapper;
import ru.mospolytech.therapy_cabinet.service.med_index.MedIndexServiceImpl;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class MedIndexControllerImpl implements MedIndexController {

    private final MedIndexMapper medIndexMapper;
    private final MedIndexServiceImpl medIndexService;

    @Override
    public void create(MedIndexCreate medIndex) {
        medIndexService.createMedIndex(medIndex);
    }

    @Override
    public MedIndexRead read(UUID id) {
        return medIndexService.findMedIndexById(id);
    }

    @Override
    public void update(UUID id, MedIndexCreate medIndex) {
        medIndexService.updateMedIndex(id, medIndex);
    }

    @Override
    public void delete(UUID id) {
        medIndexService.deleteMedIndex(id);
    }

    @Override
    public List<MedIndexCreate> readAll(Long offset, Long limit) {
        return medIndexService.findAllMedIndexes(offset, limit);
    }


    @Override
    public List<MedIndexCreate> readAllBySearch(Integer therapyId, IndexType indexType) {
        return medIndexService.findMedIndexesBySearch(therapyId, indexType);
    }

}
