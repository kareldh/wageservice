package com.example.wageservice.person.query;

import com.example.wageservice.person.model.Person;

import java.util.Optional;
import java.util.UUID;

public interface PersonQueryService {
    Optional<Person> getPerson(UUID id);
}
