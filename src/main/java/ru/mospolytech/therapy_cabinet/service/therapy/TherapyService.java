package ru.mospolytech.therapy_cabinet.service.therapy;

import org.joda.time.LocalDate;
import ru.mospolytech.therapy_cabinet.models.domain.therapy.TherapyCreate;
import ru.mospolytech.therapy_cabinet.models.domain.therapy.TherapyRead;
import ru.mospolytech.therapy_cabinet.models.domain.therapy.TherapyStatus;
import ru.mospolytech.therapy_cabinet.models.domain.therapy.TimePeriod;

import java.util.List;
import java.util.UUID;

public interface TherapyService {

    void createTherapy(TherapyCreate therapy);

    TherapyRead findTherapyById(int id);

    void updateTherapy(int id, TherapyCreate therapyCreate);

    void deleteTherapy(int id);

    List<TherapyCreate> findAllTherapies(Long offset, Long limit);

    List<TherapyCreate> findTherapiesBySearch(UUID patientId, LocalDate startDate,
                                                 LocalDate endDate, TimePeriod timePeriod,
                                                 TherapyStatus therapyStatus);

}
