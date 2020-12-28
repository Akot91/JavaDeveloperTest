package com.softwareplanttest.test.mapper;

import com.softwareplanttest.test.domain.Report;
import com.softwareplanttest.test.domain.ReportDto;
import com.softwareplanttest.test.domain.ReportResult;
import com.softwareplanttest.test.domain.ReportResultDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ReportMapperTestSuite {

    @Autowired
    private ReportMapper testee;

    @Test
    public void shouldReturnReport() {
        //Given
        ReportResultDto reportResultDto = new ReportResultDto(1L,
                "testFilm",
                1L,
                "testCharacter",
                1L,
                "testPlanet");
        ReportDto reportDto = new ReportDto(1L, "testCharacterCriteria", "testPlanetCriteria", reportResultDto);

        //When
        Report result = testee.mapToReport(reportDto);

        //Then
        Assert.assertEquals(new Long(1), result.getId());
        Assert.assertEquals("testCharacterCriteria", result.getQueryCriteriaCharacterPhrase());
        Assert.assertEquals("testPlanetCriteria", result.getQueryCriteriaPlanetName());
        Assert.assertEquals(new Long(1), result.getReportResult().getFilmId());
        Assert.assertEquals("testFilm", result.getReportResult().getFilmName());
        Assert.assertEquals(new Long(1), result.getReportResult().getCharacterId());
        Assert.assertEquals("testCharacter", result.getReportResult().getCharacterName());
        Assert.assertEquals(new Long(1), result.getReportResult().getPlanetId());
        Assert.assertEquals("testPlanet", result.getReportResult().getPlanetName());
    }

    @Test(expected = NullPointerException.class)
    public void mapToReportShouldReturnException() {
        //Given When Then
        Report result = testee.mapToReport(null);
    }

    @Test
    public void shouldReturnReportDto() {
        //Given
        ReportResult reportResult = new ReportResult(1L,
                "testFilm",
                1L,
                "testCharacter",
                1L,
                "testPlanet");
        Report report = new Report(1L, "testCharacterCriteria", "testPlanetCriteria", reportResult);

        //When
        ReportDto result = testee.mapToReportDto(report);

        //Then
        Assert.assertEquals(new Long(1), result.getId());
        Assert.assertEquals("testCharacterCriteria", result.getQueryCriteriaCharacterPhrase());
        Assert.assertEquals("testPlanetCriteria", result.getQueryCriteriaPlanetName());
        Assert.assertEquals(new Long(1), result.getReportResult().getFilmId());
        Assert.assertEquals("testFilm", result.getReportResult().getFilmName());
        Assert.assertEquals(new Long(1), result.getReportResult().getCharacterId());
        Assert.assertEquals("testCharacter", result.getReportResult().getCharacterName());
        Assert.assertEquals(new Long(1), result.getReportResult().getPlanetId());
        Assert.assertEquals("testPlanet", result.getReportResult().getPlanetName());
    }

    @Test(expected = NullPointerException.class)
    public void mapToReportDtoShouldReturnException() {
        //Given When Then
        ReportDto result = testee.mapToReportDto(null);
    }

    @Test
    public void shouldMapToReportDtoList() {
        //Given
        List<Report> reports = new ArrayList<>();
        ReportResult reportResult = new ReportResult(1L,
                "testFilm",
                1L,
                "testCharacter",
                1L,
                "testPlanet");
        reports.add(new Report(1L, "testCharacterCriteria", "testPlanetCriteria", reportResult));
        reports.add(new Report(2L, "testCharacterCriteria", "testPlanetCriteria", reportResult));
        reports.add(new Report(3L, "testCharacterCriteria", "testPlanetCriteria", reportResult));

        //When
        List<ReportDto> result = testee.mapToReportDtoList(reports);

        //Then
        Assert.assertEquals(3, result.size());
    }

    @Test
    public void shouldMapToReportList() {
        //Given
        List<ReportDto> reportDtos = new ArrayList<>();
        ReportResultDto reportResultDto = new ReportResultDto(1L,
                "testFilm",
                1L,
                "testCharacter",
                1L,
                "testPlanet");
        reportDtos.add(new ReportDto(1L, "testCharacterCriteria", "testPlanetCriteria", reportResultDto));
        reportDtos.add(new ReportDto(2L, "testCharacterCriteria", "testPlanetCriteria", reportResultDto));
        reportDtos.add(new ReportDto(3L, "testCharacterCriteria", "testPlanetCriteria", reportResultDto));

        //When
        List<Report> result = testee.mapToReportList(reportDtos);

        //Then
        Assert.assertEquals(3, result.size());
    }
}
