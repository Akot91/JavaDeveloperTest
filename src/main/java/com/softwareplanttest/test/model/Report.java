package com.softwareplanttest.test.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "report")
public class Report {

    @Id
    @JsonProperty(value = "report_id")
    private Long id;

    @Column(name = "query_criteria_character_phrase")
    @JsonProperty(value = "query_criteria_character_phrase")
    private String queryCriteriaCharacterPhrase;

    @Column(name = "query_criteria_planet_name")
    @JsonProperty(value = "query_criteria_planet_name")
    private String queryCriteriaPlanetName;

    @OneToOne(cascade = CascadeType.ALL, optional=false)
    @JoinColumn(name="result_id", unique=true)
    private ReportResult result;

    public Report() {
    }

    public Report(Long id, String queryCriteriaCharacterPhrase, String queryCriteriaPlanetName, ReportResult reportResult) {
        this.id = id;
        this.queryCriteriaCharacterPhrase = queryCriteriaCharacterPhrase;
        this.queryCriteriaPlanetName = queryCriteriaPlanetName;
        this.result = reportResult;
    }

    public Long getId() {
        return id;
    }

    public String getQueryCriteriaCharacterPhrase() {
        return queryCriteriaCharacterPhrase;
    }

    public String getQueryCriteriaPlanetName() {
        return queryCriteriaPlanetName;
    }

    public ReportResult getReportResult() {
        return result;
    }

}
