package com.example.wageservice.health;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.LivenessState;

//@Component
public class LivenessEventListener {
    private static final Logger LOG = LoggerFactory.getLogger(LivenessEventListener.class);

//    @EventListener
    public void onEvent(AvailabilityChangeEvent<LivenessState> event) {
        switch (event.getState()) {
            case BROKEN -> LOG.info("Liveness state changed to BROKEN");
            case CORRECT -> LOG.info("Liveness state changed to CORRECT");
        }
    }
}
