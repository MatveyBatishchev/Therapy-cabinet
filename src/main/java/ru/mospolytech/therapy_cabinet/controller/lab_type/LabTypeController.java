package ru.mospolytech.therapy_cabinet.controller.lab_type;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.mospolytech.therapy_cabinet.models.domain.LabType;

import java.util.List;

@RequestMapping("/lab_type")
public interface LabTypeController {
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    LabType create(@RequestBody LabType labType);

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    LabType read(@PathVariable("id") int id);

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void update(@RequestBody LabType labType);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable("id") int id);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<LabType> readAll(@RequestParam("offset") Long offset,
                          @RequestParam("limit") Long limit);
}
