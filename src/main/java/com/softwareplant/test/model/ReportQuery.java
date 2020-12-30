package com.softwareplant.test.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.softwareplant.test.exception.InvalidReportQueryException;
import org.apache.logging.log4j.util.Strings;

public class ReportQuery {

    private final String queryCriteriaCharacterPhrase;

    private final String queryCriteriaPlanetName;

    @JsonCreator
    public ReportQuery(@JsonProperty("query_criteria_character_phrase") final String queryCriteriaCharacterPhrase,
                       @JsonProperty(value = "query_criteria_planet_name") final String queryCriteriaPlanetName) {
        if (Strings.isBlank(queryCriteriaCharacterPhrase) || Strings.isBlank(queryCriteriaPlanetName)) {
            throw new InvalidReportQueryException("");
        }
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
