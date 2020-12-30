package com.softwareplanttest.test.dto;

public class ReportDto {

    private Long id;

    private String queryCriteriaCharacterPhrase;

    private String queryCriteriaPlanetName;

    private ReportEntryDto result;

    public ReportDto() {
    }

    public ReportDto(Long id, String queryCriteriaCharacterPhrase, String queryCriteriaPlanetName, ReportEntryDto reportResult) {
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

    public ReportEntryDto getReportResult() {
        return result;
    }
}
