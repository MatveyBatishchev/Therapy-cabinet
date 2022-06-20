package ru.mospolytech.therapy_cabinet.controller.therapy;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.mospolytech.therapy_cabinet.models.domain.therapy.TherapyCreate;
import ru.mospolytech.therapy_cabinet.models.domain.therapy.TherapyRead;
import ru.mospolytech.therapy_cabinet.mybatis.mappers.TherapyMapper;

import java.util.List;

@RestController
@AllArgsConstructor
public class TherapyControllerImpl implements TherapyController{

    private final TherapyMapper therapyMapper;

    @Override
    public void create(TherapyCreate therapy) {
        therapyMapper.create(therapy);
    }

    @Override
    public TherapyRead read(int id) {
        return therapyMapper.read(id);
    }

    @Override
    public void update(int id, TherapyCreate therapy) {
        therapyMapper.update(id, therapy);
    }

    @Override
    public void delete(int id) {
        therapyMapper.delete(id);
    }

    @Override
    public List<TherapyRead> readAll(Long offset, Long limit) {
        return therapyMapper.readAll(offset, limit);
    }
}
