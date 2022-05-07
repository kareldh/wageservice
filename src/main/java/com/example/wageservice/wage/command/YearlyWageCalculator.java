package com.example.wageservice.wage.command;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Component
public class YearlyWageCalculator {
    //todo hier gaan we @Cacheable op steken
    public BigDecimal calculateYearly(LocalDate contractStartDate, @Nullable LocalDate contractEndDate) {
        long yearsEmployed = ChronoUnit.YEARS.between(contractStartDate, Optional.ofNullable(contractEndDate).orElseGet(LocalDate::now));
        if (yearsEmployed > 3) {
            return BigDecimal.valueOf(40000);
        } else if (yearsEmployed > 2) {
            return BigDecimal.valueOf(35000);
        } else {
            return BigDecimal.valueOf(30000);
        }
    }
}
