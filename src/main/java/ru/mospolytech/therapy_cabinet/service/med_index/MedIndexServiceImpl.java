package ru.mospolytech.therapy_cabinet.service.med_index;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mospolytech.therapy_cabinet.models.domain.IndexType;
import ru.mospolytech.therapy_cabinet.models.domain.medindex.MedIndexCreate;
import ru.mospolytech.therapy_cabinet.models.domain.medindex.MedIndexRead;
import ru.mospolytech.therapy_cabinet.mybatis.mappers.MedIndexMapper;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MedIndexServiceImpl implements MedIndexService {

    private final MedIndexMapper medIndexMapper;

    @Override
    public void createMedIndex(MedIndexCreate medIndex) {
        medIndex.setId(UUID.randomUUID());
        medIndexMapper.create(medIndex);
    }

    @Override
    public MedIndexRead findMedIndexById(UUID id) {
        return medIndexMapper.read(id);
    }

    @Override
    public void updateMedIndex(UUID id, MedIndexCreate medIndex) {
        medIndexMapper.update(id, medIndex);
    }

    @Override
    public void deleteMedIndex(UUID id) {
        medIndexMapper.delete(id);
    }

    @Override
    public List<MedIndexCreate> findAllMedIndexes(Long offset, Long limit) {
        return medIndexMapper.readAll(offset, limit);
    }

    @Override
    public List<MedIndexCreate> findMedIndexesBySearch(Integer therapyId, IndexType indexType) {
        return medIndexMapper.readAllBySearch(therapyId, indexType);
    }
}
