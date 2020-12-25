package com.softwareplanttest.test.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfiguration {

    @Value("${test.api.people}")
    private String peopleApiUrl;

    @Value("${test.api.planets}")
    private String planetsApiUrl;

    public String getPeopleApiUrl() {
        return peopleApiUrl;
    }

    public String getPlanetsApiUrl() {
        return planetsApiUrl;
    }
}
