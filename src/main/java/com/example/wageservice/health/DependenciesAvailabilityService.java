package com.example.wageservice.health;

import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class DependenciesAvailabilityService {
    private final Set<HealthIndicator> contributors = new HashSet<>();

    public DependenciesAvailabilityService(PersonServiceHealthIndicator personServiceHealthIndicator,
                                           WageDataSourceHealthIndicator wageDataSourceHealthIndicator) {
        contributors.add(personServiceHealthIndicator);
        contributors.add(wageDataSourceHealthIndicator);
    }

    public boolean dependenciesAreUp() {
        return contributors.stream()
                .allMatch(healthIndicator -> Status.UP.equals(healthIndicator.getHealth(false).getStatus()));
    }
}
