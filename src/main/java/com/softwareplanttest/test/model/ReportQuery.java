package com.softwareplanttest.test.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReportQuery {

    @JsonProperty(value = "query_criteria_character_phrase")
    private String queryCriteriaCharacterPhrase;

    @JsonProperty(value = "query_criteria_planet_name")
    private String queryCriteriaPlanetName;

    public ReportQuery() {}

    public ReportQuery(String queryCriteriaCharacterPhrase, String queryCriteriaPlanetName) {
        this.queryCriteriaCharacterPhrase = queryCriteriaCharacterPhrase;
        this.queryCriteriaPlanetName = queryCriteriaPlanetName;
    }

    public String getQueryCriteriaCharacterPhrase() {
        return queryCriteriaCharacterPhrase;
    }

    public String getQueryCriteriaPlanetName() {
        return queryCriteriaPlanetName;
    }

}
