package ru.mospolytech.therapy_cabinet.service.therapy;

import lombok.AllArgsConstructor;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Service;
import ru.mospolytech.therapy_cabinet.models.domain.therapy.TherapyCreate;
import ru.mospolytech.therapy_cabinet.models.domain.therapy.TherapyRead;
import ru.mospolytech.therapy_cabinet.models.domain.therapy.TherapyStatus;
import ru.mospolytech.therapy_cabinet.models.domain.therapy.TimePeriod;
import ru.mospolytech.therapy_cabinet.mybatis.mappers.TherapyMapper;

import java.util.List;

@Service
@AllArgsConstructor
public class TherapyServiceImpl implements TherapyService {

    private final TherapyMapper therapyMapper;

    @Override
    public void createTherapy(TherapyCreate therapy) {
        therapyMapper.create(therapy);
    }

    @Override
    public TherapyRead findTherapyById(int id) {
        return therapyMapper.read(id);
    }

    @Override
    public void updateTherapy(int id, TherapyCreate therapyCreate) {
        therapyMapper.update(id, therapyCreate);
    }

    @Override
    public void deleteTherapy(int id) {
        therapyMapper.delete(id);
    }

    @Override
    public List<TherapyCreate> findAllTherapies(Long offset, Long limit) {
        return therapyMapper.readAll(offset, limit);
    }

    public List<TherapyCreate> findTherapiesBySearch(Integer patientId, LocalDate startDate,
                                                        LocalDate endDate, TimePeriod timePeriod,
                                                        TherapyStatus therapyStatus) {
        return therapyMapper.readAllBySearch(patientId, startDate, endDate, timePeriod, therapyStatus);
    }

}
