package ru.mospolytech.therapy_cabinet.service.med_index;

import ru.mospolytech.therapy_cabinet.models.domain.IndexType;
import ru.mospolytech.therapy_cabinet.models.domain.medindex.MedIndexCreate;
import ru.mospolytech.therapy_cabinet.models.domain.medindex.MedIndexRead;

import java.util.List;
import java.util.UUID;

public interface MedIndexService {

    void createMedIndex(MedIndexCreate medIndex);

    MedIndexRead findMedIndexById(UUID id);

    void updateMedIndex(UUID id, MedIndexCreate medIndex);

    void deleteMedIndex(UUID id);

    List<MedIndexCreate> findAllMedIndexes(Long offset, Long limit);

    List<MedIndexCreate> findMedIndexesBySearch(Integer therapyId, IndexType indexType);


}
