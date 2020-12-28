package com.softwareplanttest.test.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReportQuery {

    @JsonProperty(value = "query_criteria_character_phrase")
    private final String queryCriteriaCharacterPhrase;

    @JsonProperty(value = "query_criteria_planet_name")
    private final String queryCriteriaPlanetName;

    public ReportQuery(final String queryCriteriaCharacterPhrase, final String queryCriteriaPlanetName) {
        if (queryCriteriaCharacterPhrase == null) {
            throw new NullPointerException();
        } else  if (queryCriteriaCharacterPhrase.length() == 0) {
            throw new IllegalArgumentException();
        } else {
            this.queryCriteriaCharacterPhrase = queryCriteriaCharacterPhrase;
        }
        if (queryCriteriaPlanetName == null) {
            throw new NullPointerException();
        } else if (queryCriteriaPlanetName.length() == 0) {
            throw new IllegalArgumentException();
        } else {
            this.queryCriteriaPlanetName = queryCriteriaPlanetName;
        }
    }

    public String getQueryCriteriaCharacterPhrase() {
        return queryCriteriaCharacterPhrase;
    }

    public String getQueryCriteriaPlanetName() {
        return queryCriteriaPlanetName;
    }

}
