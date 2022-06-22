package com.example.wageservice.health;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.jdbc.DataSourceHealthIndicator;

import javax.sql.DataSource;

//@Component
public class WageDataSourceHealthIndicator extends DataSourceHealthIndicator {
    private static final Logger LOG = LoggerFactory.getLogger(WageDataSourceHealthIndicator.class);

    public WageDataSourceHealthIndicator(DataSource wageDataSource) {
        super(wageDataSource);
    }

    @Override
    public Health getHealth(boolean includeDetails) {
        LOG.trace("Checking health WageDataSource");
        return super.getHealth(includeDetails);
    }


}
