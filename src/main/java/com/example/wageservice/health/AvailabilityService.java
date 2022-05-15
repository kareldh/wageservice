package com.example.wageservice.health;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.availability.ApplicationAvailability;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class AvailabilityService {
    private static final Logger LOG = LoggerFactory.getLogger(AvailabilityService.class);

    private final ApplicationAvailability applicationAvailability;
    private final ApplicationEventPublisher applicationEventPublisher;
    private final DependenciesAvailabilityService dependenciesAvailabilityService;

    public AvailabilityService(ApplicationAvailability applicationAvailability,
                               ApplicationEventPublisher applicationEventPublisher,
                               DependenciesAvailabilityService dependenciesAvailabilityService) {
        this.applicationAvailability = applicationAvailability;
        this.applicationEventPublisher = applicationEventPublisher;
        this.dependenciesAvailabilityService = dependenciesAvailabilityService;
    }

    public synchronized boolean getAvailability() {
        return dependenciesAvailabilityService.dependenciesAreUp();
    }

    @Scheduled(fixedDelayString = "${wageservice.scheduling.scheduledAvailabilityUpdates.milliseconds:5000}")
    public void updateAvailability() {
        boolean dependenciesAreUp = getAvailability();
        LOG.debug("Checked dependencies - up: {}", dependenciesAreUp);
        updateAvailabilityIfChanged(dependenciesAreUp);
    }

    public void updateAvailabilityIfChanged(boolean dependenciesAreUp) {
        ReadinessState current = applicationAvailability.getReadinessState();

        if (dependenciesAreUp && ReadinessState.REFUSING_TRAFFIC.equals(current)) {
            LOG.warn("Updating availability to ACCEPTING_TRAFFIC");
            AvailabilityChangeEvent.publish(applicationEventPublisher, this, ReadinessState.ACCEPTING_TRAFFIC);
        } else if (!dependenciesAreUp && ReadinessState.ACCEPTING_TRAFFIC.equals(current)) {
            LOG.warn("Updating availability to REFUSING_TRAFFIC");
            AvailabilityChangeEvent.publish(applicationEventPublisher, this, ReadinessState.REFUSING_TRAFFIC);
        }
    }
}
