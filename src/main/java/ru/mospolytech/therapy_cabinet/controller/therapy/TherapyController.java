package ru.mospolytech.therapy_cabinet.controller.therapy;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.mospolytech.therapy_cabinet.models.domain.therapy.TherapyCreate;
import ru.mospolytech.therapy_cabinet.models.domain.therapy.TherapyRead;

import java.util.List;

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
    List<TherapyRead> readAll(@RequestParam("offset") Long offset,
                          @RequestParam("limit") Long limit);

}
