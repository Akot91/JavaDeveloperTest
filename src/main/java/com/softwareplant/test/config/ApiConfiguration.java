package com.softwareplant.test.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfiguration {

    @Value("${SWAPI.host}")
    private String swapiHost;

    public String getSWAPIHost() {
        return swapiHost;
    }
}
