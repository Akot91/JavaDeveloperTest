package com.softwareplanttest.test.controller;

import com.softwareplanttest.test.domain.Report;
import com.softwareplanttest.test.domain.ReportDto;
import com.softwareplanttest.test.domain.ReportResultDto;
import com.softwareplanttest.test.mapper.ReportMapper;
import com.softwareplanttest.test.model.ReportQuery;
import com.softwareplanttest.test.domain.ReportResult;
import com.softwareplanttest.test.service.DatabaseService;
import com.softwareplanttest.test.service.ReportCreator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(Controller.class)
public class ControllerTestSuite {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DatabaseService databaseService;

    @MockBean
    private ReportMapper reportMapper;

    @MockBean
    private ReportCreator reportCreator;

    @Test
    public void shouldGetAllReports() throws Exception {
        //Given
        List<Report> reports = new ArrayList<>();
        ReportResult reportResult = new ReportResult.Builder()
                .filmId(1L)
                .filmName("testFilmName")
                .characterId(2L)
                .characterName("testCharacterName")
                .planetId(3L)
                .planetName("testPlanetName")
                .build();

        reports.add(new Report(1L, "testCharacterPharse", "testPlanetName",reportResult));

        List<ReportDto> reportDtos = new ArrayList<>();
        ReportResultDto reportResultDto = new ReportResultDto.Builder()
                .filmId(1L)
                .filmName("testFilmName")
                .characterId(2L)
                .characterName("testCharacterName")
                .planetId(3L)
                .planetName("testPlanetName")
                .build();

        reportDtos.add(new ReportDto(1L, "testCharacterPharse", "testPlanetName",reportResultDto));

        when(databaseService.getAllReports()).thenReturn(reports);
        when(reportMapper.mapToReportDtoList(reports)).thenReturn(reportDtos);
        when(reportCreator.prepareReport(new ReportQuery("testCharacterPharse", "testPlanetName"))).thenReturn(reportResult);

        //When Then
        mockMvc.perform(get("/reports").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].queryCriteriaCharacterPhrase", is("testCharacterPharse")))
                .andExpect(jsonPath("$[0].queryCriteriaPlanetName", is("testPlanetName")))
                .andExpect(jsonPath("$[0].reportResult.filmId", is(1)))
                .andExpect(jsonPath("$[0].reportResult.filmName", is("testFilmName")))
                .andExpect(jsonPath("$[0].reportResult.characterId", is(2)))
                .andExpect(jsonPath("$[0].reportResult.characterName", is("testCharacterName")))
                .andExpect(jsonPath("$[0].reportResult.planetId", is(3)))
                .andExpect(jsonPath("$[0].reportResult.planetName", is("testPlanetName")));
    }

    @Test
    public void shouldGetReport() throws Exception {
        //Given
        ReportResult reportResult = new ReportResult.Builder()
                .filmId(1L)
                .filmName("testFilmName2")
                .characterId(2L)
                .characterName("testCharacterName2")
                .planetId(3L)
                .planetName("testPlanetName2")
                .build();
        Report report = new Report(1L, "testCharacterPharse", "testPlanetName",reportResult);

        ReportResultDto reportResultDto = new ReportResultDto.Builder()
                .filmId(1L)
                .filmName("testFilmName2")
                .characterId(2L)
                .characterName("testCharacterName2")
                .planetId(3L)
                .planetName("testPlanetName2")
                .build();
        ReportDto reportDto = new ReportDto(1L, "testCharacterPharse", "testPlanetName",reportResultDto);

        when(databaseService.getReport(1L)).thenReturn(Optional.of(report));
        when(reportMapper.mapToReportDto(report)).thenReturn(reportDto);
        when(reportCreator.prepareReport(new ReportQuery("testCharacterPharse", "testPlanetName"))).thenReturn(reportResult);

        //When Then
        mockMvc.perform(get("/reports/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.queryCriteriaCharacterPhrase", is("testCharacterPharse")))
                .andExpect(jsonPath("$.queryCriteriaPlanetName", is("testPlanetName")))
                .andExpect(jsonPath("$.reportResult.filmId", is(1)))
                .andExpect(jsonPath("$.reportResult.filmName", is("testFilmName2")))
                .andExpect(jsonPath("$.reportResult.characterId", is(2)))
                .andExpect(jsonPath("$.reportResult.characterName", is("testCharacterName2")))
                .andExpect(jsonPath("$.reportResult.planetId", is(3)))
                .andExpect(jsonPath("$.reportResult.planetName", is("testPlanetName2")));
    }

    @Test
    public void shouldSaveReport() {
        //Given

        //When

        //Then
    }
}
