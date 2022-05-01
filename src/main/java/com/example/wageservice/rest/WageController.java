package com.example.wageservice.rest;

import com.example.wageservice.command.WageService;
import com.example.wageservice.model.Wage;
import com.example.wageservice.query.WageQueryService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/wage")
public class WageController {
    private final WageService wageService;
    private final WageQueryService wageQueryService;

    public WageController(WageService wageService, WageQueryService wageQueryService) {
        this.wageService = wageService;
        this.wageQueryService = wageQueryService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    Wage createWage(@RequestBody Wage Wage) {
        return wageService.save(Wage);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Wage> getWage(@PathVariable UUID id) {
        return ResponseEntity.of(wageQueryService.findWage(id));
    }
}
