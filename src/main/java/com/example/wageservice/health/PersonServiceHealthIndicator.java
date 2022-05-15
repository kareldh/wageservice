package com.example.wageservice.health;

import com.example.wageservice.person.integration.PersonServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class PersonServiceHealthIndicator implements HealthIndicator {
    private static final Logger LOG = LoggerFactory.getLogger(PersonServiceHealthIndicator.class);

    private final PersonServiceClient personServiceClient;

    public PersonServiceHealthIndicator(PersonServiceClient personServiceClient) {
        this.personServiceClient = personServiceClient;
    }

    @Override
    public Health health() {
        LOG.trace("Checking health PersonService");
        try {
            if (personServiceClient.isUp()) {
                return Health.up()
                        .withDetail("checkedOn", Instant.now())
                        .build();
            } else {
                return Health.down()
                        .withDetail("checkedOn", Instant.now())
                        .build();
            }
        } catch (Exception e) {
            return Health.down(e)
                    .withDetail("checkedOn", Instant.now())
                    .build();
        }
    }
}
