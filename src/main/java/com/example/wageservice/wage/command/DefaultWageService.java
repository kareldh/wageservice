package com.example.wageservice.wage.command;

import com.example.wageservice.wage.model.Wage;
import com.example.wageservice.wage.repository.WageRepository;
import org.springframework.stereotype.Service;

@Service
public class DefaultWageService implements WageService {
    private final WageRepository WageRepository;

    public DefaultWageService(WageRepository WageRepository) {
        this.WageRepository = WageRepository;
    }

    @Override
    public Wage save(Wage Wage) {
        return WageRepository.save(Wage);
    }
}
