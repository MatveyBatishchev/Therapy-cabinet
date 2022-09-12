package ru.mospolytech.therapy_cabinet.controller.order_entry;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.mospolytech.therapy_cabinet.models.domain.order.OrderEntryCreate;
import ru.mospolytech.therapy_cabinet.models.domain.order.OrderEntryRead;

import java.util.List;

@RequestMapping("/order-entry")
@Tag(name = "Запись заказа")
@PreAuthorize("hasAnyAuthority('ADMINISTRATOR', 'DOCTOR', 'OPERATOR')")
public interface OrderEntryController {

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Добавить запись")
    void create(@RequestBody OrderEntryCreate orderEntry);

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Получить запись по ID")
    OrderEntryRead read(@PathVariable("id") int id);

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Обновить информацию о записи")
    void update(@PathVariable("id") int id,
                @RequestBody OrderEntryCreate orderEntry);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Удалить запись по ID")
    void delete(@PathVariable("id") int id);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Получить список записей")
    List<OrderEntryRead> readAll(@RequestParam(value = "offset", required = false) Long offset,
                                 @RequestParam(value = "limit", required = false) Long limit);
}
