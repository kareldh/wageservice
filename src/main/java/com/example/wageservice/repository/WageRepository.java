package com.example.wageservice.repository;

import com.example.wageservice.model.Wage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WageRepository extends CrudRepository<Wage, UUID>, CustomWageRepository {
}
