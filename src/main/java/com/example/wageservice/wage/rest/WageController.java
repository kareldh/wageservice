package com.example.wageservice.wage.rest;

import com.example.wageservice.wage.command.CalculateWageUseCase;
import com.example.wageservice.wage.command.WageService;
import com.example.wageservice.wage.model.Wage;
import com.example.wageservice.wage.query.WageQueryService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/wage")
public class WageController {
    private final CalculateWageUseCase calculateWageUseCase;
    private final WageService wageService;
    private final WageQueryService wageQueryService;

    public WageController(CalculateWageUseCase calculateWageUseCase, WageService wageService, WageQueryService wageQueryService) {
        this.calculateWageUseCase = calculateWageUseCase;
        this.wageService = wageService;
        this.wageQueryService = wageQueryService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Wage createWage(@RequestBody Wage wage) {
        return wageService.save(wage);
    }

    @PostMapping(value = "/person/{personId}", produces = MediaType.APPLICATION_JSON_VALUE)
    Wage calculateWage(@PathVariable UUID personId) {
        return calculateWageUseCase.execute(personId);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Wage> getWage(@PathVariable UUID id) {
        return ResponseEntity.of(wageQueryService.findWage(id));
    }
}
