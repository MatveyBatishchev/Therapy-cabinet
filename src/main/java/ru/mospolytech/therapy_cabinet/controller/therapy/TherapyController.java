package ru.mospolytech.therapy_cabinet.controller.therapy;

import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.mospolytech.therapy_cabinet.models.domain.prescription.PrescriptionCreate;
import ru.mospolytech.therapy_cabinet.models.domain.prescription.PrescriptionRead;
import ru.mospolytech.therapy_cabinet.models.domain.therapy.TherapyCreate;
import ru.mospolytech.therapy_cabinet.models.domain.therapy.TherapyRead;

import java.util.List;
import java.util.UUID;

@RequestMapping("/therapy")
public interface TherapyController {

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void create(@RequestBody TherapyCreate therapy);

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    TherapyRead read(@PathVariable("id") int id);

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void update(@PathVariable("id") int id,
                @RequestBody TherapyCreate therapy);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable("id") int id);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<TherapyCreate> readAll(@RequestParam("offset") Long offset,
                                @RequestParam("limit") Long limit);

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    List<TherapyCreate> readAllByPatientId(@RequestParam("patientId") UUID patientId,
                                           @RequestParam(name="startDate",required = false)
                                           @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
                                           @RequestParam(name="endDate",required = false)
                                           @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate);

    @PostMapping("/{id}/prescription")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void createPrescription(@PathVariable("id") int therapyId,
                            @RequestBody PrescriptionCreate prescription);

    @GetMapping("/{id}/prescription")
    @ResponseStatus(HttpStatus.OK)
    PrescriptionRead readPrescription(@PathVariable("id") int therapyId);

    @PutMapping("/{id}/prescription")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updatePrescription(@PathVariable("id") int therapyId, @RequestBody PrescriptionCreate prescription);

    @DeleteMapping("/{id}/prescription")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePrescription(@PathVariable("id") int therapyId);

    @GetMapping("/prescriptions")
    @ResponseStatus(HttpStatus.OK)
    List<PrescriptionCreate> readAllPrescriptions(@RequestParam("offset") Long offset,
                                                  @RequestParam("limit") Long limit);

}
