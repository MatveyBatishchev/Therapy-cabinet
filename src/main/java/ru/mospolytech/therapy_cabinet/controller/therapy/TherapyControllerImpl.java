package ru.mospolytech.therapy_cabinet.controller.therapy;

import lombok.AllArgsConstructor;
import org.joda.time.LocalDate;
import org.springframework.web.bind.annotation.RestController;
import ru.mospolytech.therapy_cabinet.models.domain.Calendar;
import ru.mospolytech.therapy_cabinet.models.domain.therapy.TherapyCreate;
import ru.mospolytech.therapy_cabinet.models.domain.therapy.TherapyRead;
import ru.mospolytech.therapy_cabinet.models.domain.therapy.TherapyStatus;
import ru.mospolytech.therapy_cabinet.models.domain.therapy.TimePeriod;
import ru.mospolytech.therapy_cabinet.mybatis.mappers.TherapyMapper;
import ru.mospolytech.therapy_cabinet.service.therapy.TherapyService;

import java.util.List;

@RestController
@AllArgsConstructor
public class TherapyControllerImpl implements TherapyController{

    private final TherapyMapper therapyMapper;
    private final TherapyService therapyService;

    @Override
    public void create(TherapyCreate therapy) {
        therapyService.createTherapy(therapy);
    }

    @Override
    public TherapyRead read(int id) {
        return therapyService.findTherapyById(id);
    }

    @Override
    public void update(int id, TherapyCreate therapy) {
        therapyService.updateTherapy(id, therapy);
    }

    @Override
    public void delete(int id) {
        therapyService.deleteTherapy(id);
    }

    @Override
    public List<TherapyCreate> readAll(Long offset, Long limit) {
        return therapyService.findAllTherapies(offset, limit);
    }

    @Override
    public List<Calendar> readTherapyCalendar(LocalDate startDate, LocalDate endDate) {
        return therapyMapper.readCalendar(startDate, endDate);
    }

    @Override
    public List<TherapyCreate> readAllBySearch(Integer patientId, LocalDate startDate,
                                               LocalDate endDate, TimePeriod timePeriod,
                                               TherapyStatus therapyStatus) {
        return therapyService.findTherapiesBySearch(patientId, startDate, endDate, timePeriod, therapyStatus);
    }
}
