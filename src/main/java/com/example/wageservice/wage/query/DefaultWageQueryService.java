package com.example.wageservice.wage.query;

import com.example.wageservice.wage.model.Wage;
import com.example.wageservice.wage.repository.WageRepository;
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
