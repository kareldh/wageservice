package com.example.wageservice.wage.query;

import com.example.wageservice.wage.model.Wage;

import java.util.Optional;
import java.util.UUID;

public interface WageQueryService {
    Optional<Wage> findWage(UUID id);
}
