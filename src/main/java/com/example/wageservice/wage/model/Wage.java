package com.example.wageservice.wage.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.util.UUID;

@JsonDeserialize(builder = Wage.Builder.class)
@Table(value = "wage")
public class Wage {
    @Id
    private UUID id;
    @Column(value = "personId")
    private UUID personId;
    @Column(value = "yearly")
    private BigDecimal yearly;

    private Wage() {
        // For Spring data
    }

    private Wage(Builder builder) {
        id = builder.id;
        personId = builder.personId;
        yearly = builder.yearly;
    }

    public UUID getId() {
        return id;
    }

    public UUID getPersonId() {
        return personId;
    }

    public BigDecimal getYearly() {
        return yearly;
    }

    public static final class Builder {
        private UUID id;
        private UUID personId;
        private BigDecimal yearly;

        public Builder() {
        }

        public Builder withId(UUID val) {
            id = val;
            return this;
        }

        public Builder withPersonId(UUID val) {
            personId = val;
            return this;
        }

        public Builder withYearly(BigDecimal val) {
            yearly = val;
            return this;
        }

        public Wage build() {
            return new Wage(this);
        }
    }
}
