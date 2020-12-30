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
    public void shouldReturnSWAPIUrl() {
        //Given When
        String result = testee.getSWAPIHost();

        //Then
        Assert.assertEquals("http://localhost:8080/", result);
    }
}
