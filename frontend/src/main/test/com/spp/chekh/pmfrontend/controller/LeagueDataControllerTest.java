package com.spp.chekh.pmfrontend.controller;

import com.spp.chekh.pmbackend.entity.LeagueEntity;
import com.spp.chekh.pmbackend.service.interfaces.LeagueService;
import com.spp.chekh.pmfrontend.view.model.entity.LeagueViewModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

@RunWith(MockitoJUnitRunner.class)
public class LeagueDataControllerTest {

    private MockMvc mockMvc;

    @Mock
    private LeagueService leagueService;

    @Mock
    private ConversionService conversionService;

    @InjectMocks
    private LeagueDataController leagueDataController;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(leagueDataController)
                .build();
    }

    @Test
    public void testGetAllLeagues() {
        final int ID = 1;
        final String NAME = "TestLeagueName";
        final int COUNTRY_ID = 1;
        final List<LeagueEntity> MOCKED_LEAGUE_ENTITY_LIST = new ArrayList<>();
        Mockito.when(leagueService.findAll()).thenReturn(MOCKED_LEAGUE_ENTITY_LIST);

        final LeagueViewModel MOCKED_LEAGUE_VIEW_MODEL = new LeagueViewModel();
        MOCKED_LEAGUE_VIEW_MODEL.setId(String.valueOf(ID));
        MOCKED_LEAGUE_VIEW_MODEL.setName(NAME);
        MOCKED_LEAGUE_VIEW_MODEL.setIdCountry(String.valueOf(COUNTRY_ID));

        final List<LeagueViewModel> MOCKED_LEAGUE_VIEW_MODEL_LIST = Arrays.asList(MOCKED_LEAGUE_VIEW_MODEL);
        Mockito.when(conversionService.convert(Mockito.any(List.class), Mockito.any(TypeDescriptor.class), Mockito.any(TypeDescriptor.class))).thenReturn(MOCKED_LEAGUE_VIEW_MODEL_LIST);

        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/league"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    //.andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", is(String.valueOf(ID))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", is(NAME)))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].idCountry", is(String.valueOf(COUNTRY_ID))));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Mockito.verify(leagueService, Mockito.times(1)).findAll();
        Mockito.verifyNoMoreInteractions(leagueService);
    }

    @Test
    public void testGetLeagueById() {
        final int ID = 1;
        final String NAME = "TestLeagueName";
        final int COUNTRY_ID = 1;
        final LeagueEntity MOCKED_LEAGUE_ENTITY = new LeagueEntity();
        Mockito.when(leagueService.findById(ID)).thenReturn(MOCKED_LEAGUE_ENTITY);

        final LeagueViewModel MOCKED_LEAGUE_VIEW_MODEL = new LeagueViewModel();
        MOCKED_LEAGUE_VIEW_MODEL.setId(String.valueOf(ID));
        MOCKED_LEAGUE_VIEW_MODEL.setName(NAME);
        MOCKED_LEAGUE_VIEW_MODEL.setIdCountry(String.valueOf(COUNTRY_ID));

        Mockito.when(conversionService.convert(Mockito.any(List.class), Mockito.any(TypeDescriptor.class), Mockito.any(TypeDescriptor.class))).thenReturn(MOCKED_LEAGUE_VIEW_MODEL);

        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/league/" + ID))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    //.andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(String.valueOf(ID))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.name", is(NAME)))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.idCountry", is(String.valueOf(COUNTRY_ID))));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Mockito.verify(leagueService, Mockito.times(1)).findById(ID);
        Mockito.verifyNoMoreInteractions(leagueService);
    }

    @Test
    public void testGetAllLeaguesByCountryId() {
        final int ID = 1;
        final String NAME = "TestLeagueName";
        final int COUNTRY_ID = 1;
        final List<LeagueEntity> MOCKED_LEAGUE_ENTITY_LIST = new ArrayList<>();
        Mockito.when(leagueService.findByIdCountry(COUNTRY_ID)).thenReturn(MOCKED_LEAGUE_ENTITY_LIST);

        final LeagueViewModel MOCKED_LEAGUE_VIEW_MODEL = new LeagueViewModel();
        MOCKED_LEAGUE_VIEW_MODEL.setId(String.valueOf(ID));
        MOCKED_LEAGUE_VIEW_MODEL.setName(NAME);
        MOCKED_LEAGUE_VIEW_MODEL.setIdCountry(String.valueOf(COUNTRY_ID));

        final List<LeagueViewModel> MOCKED_LEAGUE_VIEW_MODEL_LIST = Arrays.asList(MOCKED_LEAGUE_VIEW_MODEL);
        Mockito.when(conversionService.convert(Mockito.any(List.class), Mockito.any(TypeDescriptor.class), Mockito.any(TypeDescriptor.class))).thenReturn(MOCKED_LEAGUE_VIEW_MODEL_LIST);

        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/country/" + COUNTRY_ID + "/league"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    //.andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", is(String.valueOf(ID))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", is(NAME)))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].idCountry", is(String.valueOf(COUNTRY_ID))));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Mockito.verify(leagueService, Mockito.times(1)).findByIdCountry(COUNTRY_ID);
        Mockito.verifyNoMoreInteractions(leagueService);
    }
}