package com.example.wageservice.health;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ReadinessEventListener {
    private static final Logger LOG = LoggerFactory.getLogger(ReadinessEventListener.class);

    @EventListener
    public void onEvent(AvailabilityChangeEvent<ReadinessState> event) {
        switch (event.getState()) {
            case REFUSING_TRAFFIC -> LOG.info("Readiness state changed to REFUSING_TRAFFIC");
            case ACCEPTING_TRAFFIC -> LOG.info("Readiness state changed to ACCEPTING_TRAFFIC");
        }
    }
}
