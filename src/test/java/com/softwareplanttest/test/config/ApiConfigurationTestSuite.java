package com.softwareplanttest.test.config;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ApiConfigurationTestSuite {

    @Autowired
    private ApiConfiguration testee;

    @Test
    public void shouldReturnPeopleApiUrl() {
        //Given When
        String result = testee.getPeopleApiUrl();

        //Then
        Assert.assertEquals("http://localhost:8080/api/people/", result);
    }

    @Test
    public void shouldReturnPlanetsAPiUrl() {
        //Given When
        String result = testee.getPlanetsApiUrl();

        //Then
        Assert.assertEquals("http://localhost:8080/api/planets/", result);
    }
}
