package com.example.wageservice.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfiguration {

    @Bean
    public NamedParameterJdbcTemplate wagesJdbcTemplate(DataSource hrDataSource) {
        return new NamedParameterJdbcTemplate(hrDataSource);
    }

    @Bean
    @ConfigurationProperties(prefix = "wageservice.datasource.wages.configuration")
    public DataSource wageDataSource(DataSourceProperties wagesDataSourceProperties) {
        return wagesDataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "wageservice.datasource.wages")
    public DataSourceProperties wagesDataSourceProperties() {
        return new DataSourceProperties();
    }
}
