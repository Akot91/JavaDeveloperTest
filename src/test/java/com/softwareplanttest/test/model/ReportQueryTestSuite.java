package com.softwareplanttest.test.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ReportQueryTestSuite {

    @Test
    public void shouldReturnCriteriaCharacterPharse() {
        //Given //When
        ReportQuery testee = new ReportQuery("Luke Skywalker", "Alderaan");

        //Then
        Assert.assertEquals("Luke Skywalker", testee.getQueryCriteriaCharacterPhrase());
    }

    @Test
    public void shouldReturnCriteriaPlanetName() {
        //Given //When
        ReportQuery testee = new ReportQuery("Luke Skywalker", "Alderaan");

        //Then
        Assert.assertEquals("Alderaan", testee.getQueryCriteriaPlanetName());
    }

    @Test(expected = NullPointerException.class)
    public void settingNullCharacterNameShouldReturnException() {
        //Given //When //Then
        ReportQuery testee = new ReportQuery(null, "Alderaan");
    }

    @Test(expected = IllegalArgumentException.class)
    public void settingEmptyCharacterNameShouldReturnException() {
        //Given //When //Then
        ReportQuery testee = new ReportQuery("", "Alderaan");
    }

    @Test(expected = NullPointerException.class)
    public void settingNullPlanetNameShouldReturnException() {
        //Given //When //Then
        ReportQuery testee = new ReportQuery("Luke Skywalker", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void settingEmptyPlanetNameShouldReturnException() {
        //Given //When //Then
        ReportQuery testee = new ReportQuery("Luke Skywalker", "");
    }
}
