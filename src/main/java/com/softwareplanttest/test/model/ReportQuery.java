package com.softwareplanttest.test.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReportQuery {

    @JsonProperty(value = "query_criteria_character_phrase")
    private final String queryCriteriaCharacterPhrase;

    @JsonProperty(value = "query_criteria_planet_name")
    private final String queryCriteriaPlanetName;

    public ReportQuery(final String queryCriteriaCharacterPhrase, final String queryCriteriaPlanetName) {
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
