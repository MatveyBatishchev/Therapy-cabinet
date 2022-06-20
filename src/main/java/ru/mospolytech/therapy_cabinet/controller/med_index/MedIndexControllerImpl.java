package ru.mospolytech.therapy_cabinet.controller.med_index;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.mospolytech.therapy_cabinet.models.domain.medindex.MedIndexCreate;
import ru.mospolytech.therapy_cabinet.models.domain.medindex.MedIndexRead;
import ru.mospolytech.therapy_cabinet.mybatis.mappers.MedIndexMapper;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class MedIndexControllerImpl implements MedIndexController {

    private final MedIndexMapper medIndexMapper;

    @Override
    public void create(MedIndexCreate medIndex) {
        medIndex.setId(UUID.randomUUID());
        medIndexMapper.create(medIndex);
    }

    @Override
    public MedIndexRead read(UUID id) {
        return medIndexMapper.read(id);
    }

    @Override
    public void update(UUID id, MedIndexCreate medIndex) {
        medIndexMapper.update(id, medIndex);
    }

    @Override
    public void delete(UUID id) {
        medIndexMapper.delete(id);
    }

    @Override
    public List<MedIndexRead> readAll(Long offset, Long limit) {
        return medIndexMapper.readAll(offset, limit);
    }

}
