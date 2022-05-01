package com.example.wageservice.query;

import com.example.wageservice.model.Wage;
import com.example.wageservice.repository.WageRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DefaultWageQueryService implements WageQueryService {
    private final WageRepository wageRepository;

    public DefaultWageQueryService(WageRepository wageRepository) {
        this.wageRepository = wageRepository;
    }

    @Override
    public Optional<Wage> findWage(UUID id) {
        return wageRepository.findById(id);
    }
}
