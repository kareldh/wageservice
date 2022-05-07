package com.example.wageservice.wage.command;

import com.example.wageservice.person.model.Person;
import com.example.wageservice.person.query.PersonQueryService;
import com.example.wageservice.wage.model.Wage;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public class CalculateWageUseCase {
    private final PersonQueryService personQueryService;
    private final WageService wageService;
    private final YearlyWageCalculator yearlyWageCalculator;

    public CalculateWageUseCase(PersonQueryService personQueryService,
                                WageService wageService,
                                YearlyWageCalculator yearlyWageCalculator) {
        this.personQueryService = personQueryService;
        this.wageService = wageService;
        this.yearlyWageCalculator = yearlyWageCalculator;
    }

    public Wage execute(UUID personId) {
        Person person = personQueryService.getPerson(personId).orElseThrow(() -> new IllegalArgumentException("Person with the given id " + personId + " doesn't exist"));
        BigDecimal yearlyWage = yearlyWageCalculator.calculateYearly(person.getContractStartDate(), person.getContractEndDate());

        return wageService.save(new Wage.Builder()
                .withPersonId(personId)
                .withYearly(yearlyWage)
                .build());
    }
}
