package ru.mospolytech.therapy_cabinet.controller.index_type;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.mospolytech.therapy_cabinet.models.domain.IndexType;
import ru.mospolytech.therapy_cabinet.mybatis.mappers.IndexTypeMapper;

import java.util.List;

@RestController
@AllArgsConstructor
public class IndexTypeControllerImpl implements IndexTypeController {

    private final IndexTypeMapper indexTypeMapper;

    @Override
    public void create(IndexType indexType) {
        indexTypeMapper.create(indexType);
    }

    @Override
    public IndexType read(int id) {
        return indexTypeMapper.read(id);
    }

    @Override
    public void update(IndexType indexType) {
        indexTypeMapper.update(indexType);
    }

    @Override
    public void delete(int id) {
        indexTypeMapper.delete(id);
    }

    @Override
    public List<IndexType> readAll(Long offset, Long limit) {
        return indexTypeMapper.readAll(offset, limit);
    }

}
