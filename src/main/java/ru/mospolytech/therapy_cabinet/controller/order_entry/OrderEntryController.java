package ru.mospolytech.therapy_cabinet.controller.order_entry;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.mospolytech.therapy_cabinet.models.domain.order.OrderEntryCreate;
import ru.mospolytech.therapy_cabinet.models.domain.order.OrderEntryRead;

import java.util.List;

@RequestMapping("/order-entry")
public interface OrderEntryController {

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void create(@RequestBody OrderEntryCreate orderEntry);

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    OrderEntryRead read(@PathVariable("id") int id);

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void update(@PathVariable("id") int id,
                @RequestBody OrderEntryCreate orderEntry);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable("id") int id);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<OrderEntryRead> readAll(@RequestParam("offset") Long offset,
                                 @RequestParam("limit") Long limit);

}
