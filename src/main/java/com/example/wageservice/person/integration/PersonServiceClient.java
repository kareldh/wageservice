package com.example.wageservice.person.integration;

import com.example.wageservice.person.integration.config.PersonServiceClientProperties;
import com.example.wageservice.person.integration.converter.PersonConverter;
import com.example.wageservice.person.model.Person;
import com.example.wageservice.person.query.PersonQueryService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonServiceClient implements PersonQueryService {
    private final PersonConverter personConverter;
    private final PersonServiceClientProperties personServiceClientProperties;
    private final WebClient personServiceWebClient;

    public PersonServiceClient(PersonConverter personConverter,
                               PersonServiceClientProperties personServiceClientProperties,
                               WebClient personServiceWebClient) {
        this.personConverter = personConverter;
        this.personServiceClientProperties = personServiceClientProperties;
        this.personServiceWebClient = personServiceWebClient;
    }

    @Override
    public Optional<Person> getPerson(UUID id) {
        Map<String, String> pathVariables = Map.of(
                "id", id.toString()
        );

        return personServiceWebClient.get()
                .uri(uriBuilder -> uriBuilder.path(personServiceClientProperties.getGetPerson()).build(pathVariables))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(com.example.wageservice.person.integration.dto.Person.class)
                .onErrorResume(WebClientResponseException.NotFound.class, notFound -> Mono.empty())
                .blockOptional()
                .map(personConverter::convert);
    }

    public boolean isUp() {
        return true;//todo
    }
}
