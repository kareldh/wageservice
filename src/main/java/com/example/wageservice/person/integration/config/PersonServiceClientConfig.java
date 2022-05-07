package com.example.wageservice.person.integration.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@EnableConfigurationProperties
@Configuration
public class PersonServiceClientConfig {

    @Bean
    @ConfigurationProperties(prefix = "integration.personservice")
    PersonServiceClientProperties personServiceClientProperties() {
        return new PersonServiceClientProperties();
    }

    @Bean
    WebClient personServiceWebClient(PersonServiceClientProperties personServiceClientProperties) {
        return WebClient.create(personServiceClientProperties.getBaseUrl());
    }
}
