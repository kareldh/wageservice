package com.example.wageservice.person.model;

import java.time.LocalDate;
import java.util.UUID;

public class Person {
    private final UUID id;
    private final String firstName;
    private final String lastName;
    private final LocalDate contractStartDate;
    private final LocalDate contractEndDate;

    private Person(Builder builder) {
        id = builder.id;
        firstName = builder.firstName;
        lastName = builder.lastName;
        contractStartDate = builder.contractStartDate;
        contractEndDate = builder.contractEndDate;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getContractStartDate() {
        return contractStartDate;
    }

    public LocalDate getContractEndDate() {
        return contractEndDate;
    }

    public static final class Builder {
        private UUID id;
        private String firstName;
        private String lastName;
        private LocalDate contractStartDate;
        private LocalDate contractEndDate;

        public Builder() {
        }

        public Builder withId(UUID val) {
            id = val;
            return this;
        }

        public Builder withFirstName(String val) {
            firstName = val;
            return this;
        }

        public Builder withLastName(String val) {
            lastName = val;
            return this;
        }

        public Builder withContractStartDate(LocalDate val) {
            contractStartDate = val;
            return this;
        }

        public Builder withContractEndDate(LocalDate val) {
            contractEndDate = val;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}
