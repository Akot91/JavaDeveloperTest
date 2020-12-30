package com.softwareplant.test.controller;

import com.softwareplant.test.service.ReportService;
import com.softwareplant.test.dto.ReportDto;
import com.softwareplant.test.dto.ReportEntryDto;
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

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ReportController.class)
public class ReportControllerTestSuite {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReportService reportService;

    @Test
    public void shouldGetAllReports() throws Exception {
        //Given
        List<ReportDto> reportDtos = new ArrayList<>();
        ReportEntryDto reportEntryDto = new ReportEntryDto.Builder()
                .filmId(1L)
                .filmName("testFilmName")
                .characterId(2L)
                .characterName("testCharacterName")
                .planetId(3L)
                .planetName("testPlanetName")
                .build();

        reportDtos.add(new ReportDto(1L, "testCharacterPharse", "testPlanetName", reportEntryDto));

        when(reportService.getAll()).thenReturn(reportDtos);

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
        ReportEntryDto reportEntryDto = new ReportEntryDto.Builder()
                .filmId(1L)
                .filmName("testFilmName2")
                .characterId(2L)
                .characterName("testCharacterName2")
                .planetId(3L)
                .planetName("testPlanetName2")
                .build();
        ReportDto reportDto = new ReportDto(1L, "testCharacterPharse", "testPlanetName", reportEntryDto);

        when(reportService.get(1L)).thenReturn(reportDto);

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
}
