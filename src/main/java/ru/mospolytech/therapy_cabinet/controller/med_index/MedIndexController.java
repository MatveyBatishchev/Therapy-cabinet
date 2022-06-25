package ru.mospolytech.therapy_cabinet.controller.med_index;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.mospolytech.therapy_cabinet.models.domain.IndexType;
import ru.mospolytech.therapy_cabinet.models.domain.medindex.MedIndexCreate;
import ru.mospolytech.therapy_cabinet.models.domain.medindex.MedIndexRead;

import java.util.List;
import java.util.UUID;

@RequestMapping("/med-index")
public interface MedIndexController {

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void create(@RequestBody MedIndexCreate medIndex);

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    MedIndexRead read(@PathVariable("id") UUID id);

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void update(@PathVariable("id") UUID id,
                @RequestBody MedIndexCreate medIndex);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable("id") UUID id);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<MedIndexCreate> readAll(@RequestParam("offset") Long offset,
                                 @RequestParam("limit") Long limit);

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    List<MedIndexCreate> readAllBySearch(@RequestParam(name="therapyId", required = false) Integer therapyId,
                                         @RequestParam(name="indexType", required = false) IndexType indexType);

}
