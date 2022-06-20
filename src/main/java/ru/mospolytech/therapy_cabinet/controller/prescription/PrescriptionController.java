package ru.mospolytech.therapy_cabinet.controller.prescription;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.mospolytech.therapy_cabinet.models.domain.prescription.PrescriptionCreate;
import ru.mospolytech.therapy_cabinet.models.domain.prescription.PrescriptionRead;

import java.util.List;
import java.util.UUID;

@RequestMapping("/prescription")
public interface PrescriptionController {

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void create(@RequestBody PrescriptionCreate prescription);

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    PrescriptionRead read(@PathVariable("id") UUID id);

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void update(@PathVariable("id") UUID id,
                @RequestBody  PrescriptionCreate prescription);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable("id") UUID id);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<PrescriptionRead> readAll(@RequestParam("offset") Long offset,
                                   @RequestParam("limit") Long limit);

}
