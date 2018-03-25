package com.spp.chekh.pmfrontend.controller;

import com.spp.chekh.pmbackend.entity.TeamEntity;
import com.spp.chekh.pmbackend.service.interfaces.TeamService;
import com.spp.chekh.pmfrontend.view.model.entity.TeamViewModel;
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
public class TeamDataControllerTest {

    private MockMvc mockMvc;

    @Mock
    private TeamService teamService;

    @Mock
    private ConversionService conversionService;

    @InjectMocks
    private TeamDataController teamDataController;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(teamDataController)
                .build();
    }

    @Test
    public void testGetAllTeams() {
        final int ID = 1;
        final String NAME = "TestTeamName";
        final int LEAGUE_ID = 1;
        final List<TeamEntity> MOCKED_TEAM_ENTITY_LIST = new ArrayList<>();
        Mockito.when(teamService.findAll()).thenReturn(MOCKED_TEAM_ENTITY_LIST);

        final TeamViewModel MOCKED_TEAM_VIEW_MODEL = new TeamViewModel();
        MOCKED_TEAM_VIEW_MODEL.setId(String.valueOf(ID));
        MOCKED_TEAM_VIEW_MODEL.setName(NAME);
        MOCKED_TEAM_VIEW_MODEL.setIdLeague(String.valueOf(LEAGUE_ID));

        final List<TeamViewModel> MOCKED_TEAM_VIEW_MODEL_LIST = Arrays.asList(MOCKED_TEAM_VIEW_MODEL);
        Mockito.when(conversionService.convert(Mockito.any(List.class), Mockito.any(TypeDescriptor.class), Mockito.any(TypeDescriptor.class))).thenReturn(MOCKED_TEAM_VIEW_MODEL_LIST);

        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/team"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    //.andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", is(String.valueOf(ID))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", is(NAME)))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].idLeague", is(String.valueOf(LEAGUE_ID))));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Mockito.verify(teamService, Mockito.times(1)).findAll();
        Mockito.verifyNoMoreInteractions(teamService);
    }

    @Test
    public void testGetTeamById() {
        final int ID = 1;
        final String NAME = "TestLeagueName";
        final int LEAGUE_ID = 1;
        final TeamEntity MOCKED_TEAM_ENTITY = new TeamEntity();
        Mockito.when(teamService.findById(ID)).thenReturn(MOCKED_TEAM_ENTITY);

        final TeamViewModel MOCKED_TEAM_VIEW_MODEL = new TeamViewModel();
        MOCKED_TEAM_VIEW_MODEL.setId(String.valueOf(ID));
        MOCKED_TEAM_VIEW_MODEL.setName(NAME);
        MOCKED_TEAM_VIEW_MODEL.setIdLeague(String.valueOf(LEAGUE_ID));

        Mockito.when(conversionService.convert(Mockito.any(List.class), Mockito.any(TypeDescriptor.class), Mockito.any(TypeDescriptor.class))).thenReturn(MOCKED_TEAM_VIEW_MODEL);

        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/team/" + ID))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    //.andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(String.valueOf(ID))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.name", is(NAME)))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.idLeague", is(String.valueOf(LEAGUE_ID))));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Mockito.verify(teamService, Mockito.times(1)).findById(ID);
        Mockito.verifyNoMoreInteractions(teamService);
    }

    @Test
    public void testGetAllTeamsByLeagueId() {
        final int ID = 1;
        final String NAME = "TestTeamName";
        final int LEAGUE_ID = 1;
        final List<TeamEntity> MOCKED_TEAM_ENTITY_LIST = new ArrayList<>();
        Mockito.when(teamService.findByIdLeague(LEAGUE_ID)).thenReturn(MOCKED_TEAM_ENTITY_LIST);

        final TeamViewModel MOCKED_TEAM_VIEW_MODEL = new TeamViewModel();
        MOCKED_TEAM_VIEW_MODEL.setId(String.valueOf(ID));
        MOCKED_TEAM_VIEW_MODEL.setName(NAME);
        MOCKED_TEAM_VIEW_MODEL.setIdLeague(String.valueOf(LEAGUE_ID));

        final List<TeamViewModel> MOCKED_TEAM_VIEW_MODEL_LIST = Arrays.asList(MOCKED_TEAM_VIEW_MODEL);
        Mockito.when(conversionService.convert(Mockito.any(List.class), Mockito.any(TypeDescriptor.class), Mockito.any(TypeDescriptor.class))).thenReturn(MOCKED_TEAM_VIEW_MODEL_LIST);

        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/league/" + LEAGUE_ID + "/team"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    //.andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", is(String.valueOf(ID))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", is(NAME)))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].idLeague", is(String.valueOf(LEAGUE_ID))));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Mockito.verify(teamService, Mockito.times(1)).findByIdLeague(LEAGUE_ID);
        Mockito.verifyNoMoreInteractions(teamService);
    }
}