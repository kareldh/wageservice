package com.example.wageservice.person.integration.config;

public class PersonServiceClientProperties {
    private String baseUrl;
    private String getPerson = "/api/person/{id}";
    private String isUp = "/actuator/health";
    private String healthContentType = "application/vnd.spring-boot.actuator.v3+json";

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getGetPerson() {
        return getPerson;
    }

    public void setGetPerson(String getPerson) {
        this.getPerson = getPerson;
    }

    public String getIsUp() {
        return isUp;
    }

    public void setIsUp(String isUp) {
        this.isUp = isUp;
    }

    public String getHealthContentType() {
        return healthContentType;
    }

    public void setHealthContentType(String healthContentType) {
        this.healthContentType = healthContentType;
    }
}
