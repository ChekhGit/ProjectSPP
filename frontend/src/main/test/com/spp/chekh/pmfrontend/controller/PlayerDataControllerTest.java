package com.spp.chekh.pmfrontend.controller;

import com.spp.chekh.pmbackend.entity.LeagueEntity;
import com.spp.chekh.pmbackend.entity.PlayerEntity;
import com.spp.chekh.pmbackend.service.interfaces.PlayerService;
import com.spp.chekh.pmfrontend.view.model.custom.PlayerTableViewModel;
import com.spp.chekh.pmfrontend.view.model.entity.LeagueViewModel;
import com.spp.chekh.pmfrontend.view.model.entity.PlayerViewModel;
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
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;


@RunWith(MockitoJUnitRunner.class)
public class PlayerDataControllerTest {

    private MockMvc mockMvc;

    @Mock
    private PlayerService playerService;

    @Mock
    private ConversionService conversionService;

    @InjectMocks
    private PlayerDataController playerDataController;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(playerDataController)
                .build();
    }

    @Test
    public void testGetAllPlayers() {
        final int ID = 1;
        final String NAME = "TestPlayerName";
        final String SURNAME = "TestPlayerSurname";
        final int POSITION_ID = 1;
        final int TEAM_ID = 1;
        final int STATISTIC_ID = 1;
        final List<PlayerEntity> MOCKED_PLAYER_ENTITY_LIST = new ArrayList<>();
        Mockito.when(playerService.findAll()).thenReturn(MOCKED_PLAYER_ENTITY_LIST);

        final PlayerViewModel MOCKED_PLAYER_VIEW_MODEL = new PlayerViewModel();
        MOCKED_PLAYER_VIEW_MODEL.setId(String.valueOf(ID));
        MOCKED_PLAYER_VIEW_MODEL.setName(NAME);
        MOCKED_PLAYER_VIEW_MODEL.setSurname(SURNAME);
        MOCKED_PLAYER_VIEW_MODEL.setIdTeam(String.valueOf(TEAM_ID));
        MOCKED_PLAYER_VIEW_MODEL.setIdPlayerStatistic(String.valueOf(STATISTIC_ID));
        MOCKED_PLAYER_VIEW_MODEL.setIdPosition(String.valueOf(POSITION_ID));

        final List<PlayerViewModel> PLAYER_VIEW_MODEL_LIST = Arrays.asList(MOCKED_PLAYER_VIEW_MODEL);
        Mockito.when(conversionService.convert(Mockito.any(List.class), Mockito.any(TypeDescriptor.class), Mockito.any(TypeDescriptor.class))).thenReturn(PLAYER_VIEW_MODEL_LIST);

        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/player"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    //.andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", is(String.valueOf(ID))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", is(NAME)))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].surname", is(SURNAME)))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].idPosition", is(String.valueOf(POSITION_ID))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].idTeam", is(String.valueOf(TEAM_ID))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].idPlayerStatistic", is(String.valueOf(STATISTIC_ID))));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Mockito.verify(playerService, Mockito.times(1)).findAll();
        Mockito.verifyNoMoreInteractions(playerService);
    }

    @Test
    public void testGetPlayerById() {
        final int ID  = 1;
        final String NAME = "TestPlayerName";
        final String SURNAME = "TestPlayerSurname";
        final String POSITION = "FWD";
        final int STATISTIC_ID = 1;
        final int LOST_MATCHES = 10;
        final int WIN_MATCHES = 100;
        final int DRAW_MATCHES = 30;
        final int GOALS = 120;
        final int KEY_PASSES = 20;
        final int RED_CARDS = 1;
        final int YELLOW_CARDS = 10;
        final PlayerEntity MOCKED_PLAYER_ENTITY = new PlayerEntity();
        Mockito.when(playerService.findById(ID)).thenReturn(MOCKED_PLAYER_ENTITY);

        final PlayerTableViewModel MOCKED_PLAYER_TABLE_VIEW_MODEL = new PlayerTableViewModel();
        MOCKED_PLAYER_TABLE_VIEW_MODEL.setId(String.valueOf(ID));
        MOCKED_PLAYER_TABLE_VIEW_MODEL.setName(NAME);
        MOCKED_PLAYER_TABLE_VIEW_MODEL.setSurname(SURNAME);
        MOCKED_PLAYER_TABLE_VIEW_MODEL.setIdStatistic(String.valueOf(STATISTIC_ID));
        MOCKED_PLAYER_TABLE_VIEW_MODEL.setLostMatches(String.valueOf(LOST_MATCHES));
        MOCKED_PLAYER_TABLE_VIEW_MODEL.setWinMatches(String.valueOf(WIN_MATCHES));
        MOCKED_PLAYER_TABLE_VIEW_MODEL.setDrawMatches(String.valueOf(DRAW_MATCHES));
        MOCKED_PLAYER_TABLE_VIEW_MODEL.setGoals(String.valueOf(GOALS));
        MOCKED_PLAYER_TABLE_VIEW_MODEL.setKeyPasses(String.valueOf(KEY_PASSES));
        MOCKED_PLAYER_TABLE_VIEW_MODEL.setRedCards(String.valueOf(RED_CARDS));
        MOCKED_PLAYER_TABLE_VIEW_MODEL.setYellowCards(String.valueOf(YELLOW_CARDS));
        MOCKED_PLAYER_TABLE_VIEW_MODEL.setPosition(POSITION);

        Mockito.when(conversionService.convert(Mockito.any(List.class), Mockito.any(TypeDescriptor.class), Mockito.any(TypeDescriptor.class))).thenReturn(MOCKED_PLAYER_TABLE_VIEW_MODEL);

        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/player/" + ID))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    //.andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(String.valueOf(ID))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.name", is(NAME)))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.position", is(POSITION)))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.idStatistic", is(String.valueOf(STATISTIC_ID))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.lostMatches", is(String.valueOf(LOST_MATCHES))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.winMatches", is(String.valueOf(WIN_MATCHES))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.drawMatches", is(String.valueOf(DRAW_MATCHES))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.goals", is(String.valueOf(GOALS))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.keyPasses", is(String.valueOf(KEY_PASSES))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.redCards", is(String.valueOf(RED_CARDS))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.yellowCards", is(String.valueOf(YELLOW_CARDS))));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Mockito.verify(playerService, Mockito.times(1)).findById(ID);
        Mockito.verifyNoMoreInteractions(playerService);
    }

    @Test
    public void testGetAllPlayersByTeamId() {
        final int ID  = 1;
        final String NAME = "TestPlayerName";
        final String SURNAME = "TestPlayerSurname";
        final String POSITION = "FWD";
        final int STATISTIC_ID = 1;
        final int TEAM_ID = 1;
        final int LOST_MATCHES = 10;
        final int WIN_MATCHES = 100;
        final int DRAW_MATCHES = 30;
        final int GOALS = 120;
        final int KEY_PASSES = 20;
        final int RED_CARDS = 1;
        final int YELLOW_CARDS = 10;
        final List<PlayerEntity> MOCKED_PLAYER_ENTITY_LIST = new ArrayList<>();
        Mockito.when(playerService.findByIdTeam(TEAM_ID)).thenReturn(MOCKED_PLAYER_ENTITY_LIST);

        final PlayerTableViewModel MOCKED_PLAYER_TABLE_VIEW_MODEL = new PlayerTableViewModel();
        MOCKED_PLAYER_TABLE_VIEW_MODEL.setId(String.valueOf(ID));
        MOCKED_PLAYER_TABLE_VIEW_MODEL.setName(NAME);
        MOCKED_PLAYER_TABLE_VIEW_MODEL.setSurname(SURNAME);
        MOCKED_PLAYER_TABLE_VIEW_MODEL.setIdStatistic(String.valueOf(STATISTIC_ID));
        MOCKED_PLAYER_TABLE_VIEW_MODEL.setLostMatches(String.valueOf(LOST_MATCHES));
        MOCKED_PLAYER_TABLE_VIEW_MODEL.setWinMatches(String.valueOf(WIN_MATCHES));
        MOCKED_PLAYER_TABLE_VIEW_MODEL.setDrawMatches(String.valueOf(DRAW_MATCHES));
        MOCKED_PLAYER_TABLE_VIEW_MODEL.setGoals(String.valueOf(GOALS));
        MOCKED_PLAYER_TABLE_VIEW_MODEL.setKeyPasses(String.valueOf(KEY_PASSES));
        MOCKED_PLAYER_TABLE_VIEW_MODEL.setRedCards(String.valueOf(RED_CARDS));
        MOCKED_PLAYER_TABLE_VIEW_MODEL.setYellowCards(String.valueOf(YELLOW_CARDS));
        MOCKED_PLAYER_TABLE_VIEW_MODEL.setPosition(POSITION);

        final List<PlayerTableViewModel> MOCKED_PLAYER_TABLE_VIEW_MODEL_LIST = Arrays.asList(MOCKED_PLAYER_TABLE_VIEW_MODEL);
        Mockito.when(conversionService.convert(Mockito.any(List.class), Mockito.any(TypeDescriptor.class), Mockito.any(TypeDescriptor.class))).thenReturn(MOCKED_PLAYER_TABLE_VIEW_MODEL_LIST);

        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/team/" + TEAM_ID + "/player"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    //.andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", is(String.valueOf(ID))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", is(NAME)))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].position", is(POSITION)))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].idStatistic", is(String.valueOf(STATISTIC_ID))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].lostMatches", is(String.valueOf(LOST_MATCHES))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].winMatches", is(String.valueOf(WIN_MATCHES))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].drawMatches", is(String.valueOf(DRAW_MATCHES))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].goals", is(String.valueOf(GOALS))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].keyPasses", is(String.valueOf(KEY_PASSES))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].redCards", is(String.valueOf(RED_CARDS))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].yellowCards", is(String.valueOf(YELLOW_CARDS))));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Mockito.verify(playerService, Mockito.times(1)).findByIdTeam(TEAM_ID);
        Mockito.verifyNoMoreInteractions(playerService);
    }
}