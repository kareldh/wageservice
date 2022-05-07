package com.example.wageservice.person.integration.converter;

import com.example.wageservice.person.integration.dto.Person;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PersonConverter implements Converter<Person, com.example.wageservice.person.model.Person> {
    @Override
    public com.example.wageservice.person.model.Person convert(Person source) {
        return new com.example.wageservice.person.model.Person.Builder()
                .withId(source.getId())
                .withFirstName(source.getFirstName())
                .withLastName(source.getLastName())
                .withContractStartDate(source.getContractStartDate())
                .withContractEndDate(source.getContractEndDate())
                .build();
    }
}
