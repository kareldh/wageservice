package com.example.wageservice.query;

import com.example.wageservice.model.Wage;

import java.util.Optional;
import java.util.UUID;

public interface WageQueryService {
    Optional<Wage> findWage(UUID id);
}
