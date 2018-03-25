package com.spp.chekh.pmfrontend.controller;

import com.spp.chekh.pmbackend.entity.PlayerEntity;
import com.spp.chekh.pmbackend.entity.PlayerStatisticEntity;
import com.spp.chekh.pmbackend.service.interfaces.PlayerService;
import com.spp.chekh.pmbackend.service.interfaces.PlayerStatisticService;
import com.spp.chekh.pmfrontend.view.model.entity.PlayerStatisticViewModel;
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
public class PlayerStatisticDataControllerTest {

    private MockMvc mockMvc;

    @Mock
    private PlayerStatisticService playerStatisticService;

    @Mock
    private PlayerService playerService;

    @Mock
    private ConversionService conversionService;

    @InjectMocks
    private PlayerStatisticDataController playerStatisticDataController;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(playerStatisticDataController)
                .build();
    }

    @Test
    public void testGetAllPlayersStatistics() {
        final int ID  = 1;
        final int LOST_MATCHES = 10;
        final int WIN_MATCHES = 100;
        final int DRAW_MATCHES = 30;
        final int GOALS = 120;
        final int KEY_PASSES = 20;
        final int RED_CARDS = 1;
        final int YELLOW_CARDS = 10;
        final List<PlayerStatisticEntity> MOCKED_PLAYER_STATISTIC_ENTITY_LIST = new ArrayList<>();
        Mockito.when(playerStatisticService.findAll()).thenReturn(MOCKED_PLAYER_STATISTIC_ENTITY_LIST);

        final PlayerStatisticViewModel MOCKED_PLAYER_STATISTIC_VIEW_MODEL = new PlayerStatisticViewModel();
        MOCKED_PLAYER_STATISTIC_VIEW_MODEL.setId(String.valueOf(ID));
        MOCKED_PLAYER_STATISTIC_VIEW_MODEL.setLostMatches(String.valueOf(LOST_MATCHES));
        MOCKED_PLAYER_STATISTIC_VIEW_MODEL.setWinMatches(String.valueOf(WIN_MATCHES));
        MOCKED_PLAYER_STATISTIC_VIEW_MODEL.setDrawMatches(String.valueOf(DRAW_MATCHES));
        MOCKED_PLAYER_STATISTIC_VIEW_MODEL.setGoals(String.valueOf(GOALS));
        MOCKED_PLAYER_STATISTIC_VIEW_MODEL.setKeyPasses(String.valueOf(KEY_PASSES));
        MOCKED_PLAYER_STATISTIC_VIEW_MODEL.setRedCards(String.valueOf(RED_CARDS));
        MOCKED_PLAYER_STATISTIC_VIEW_MODEL.setYellowCards(String.valueOf(YELLOW_CARDS));

        final List<PlayerStatisticViewModel> MOCKED_PLAYER_STATISTIC_VIEW_MODEL_LIST = Arrays.asList(MOCKED_PLAYER_STATISTIC_VIEW_MODEL);
        Mockito.when(conversionService.convert(Mockito.any(List.class), Mockito.any(TypeDescriptor.class), Mockito.any(TypeDescriptor.class))).thenReturn(MOCKED_PLAYER_STATISTIC_VIEW_MODEL_LIST);

        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/player/statistic"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    //.andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", is(String.valueOf(ID))))
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

        Mockito.verify(playerStatisticService, Mockito.times(1)).findAll();
        Mockito.verifyNoMoreInteractions(playerStatisticService);
    }

    @Test
    public void testGetPlayerStatisticById() {
        final int ID  = 1;
        final int LOST_MATCHES = 10;
        final int WIN_MATCHES = 100;
        final int DRAW_MATCHES = 30;
        final int GOALS = 120;
        final int KEY_PASSES = 20;
        final int RED_CARDS = 1;
        final int YELLOW_CARDS = 10;
        final PlayerStatisticEntity MOCKED_PLAYER_STATISTIC_ENTITY = new PlayerStatisticEntity();
        Mockito.when(playerStatisticService.findById(ID)).thenReturn(MOCKED_PLAYER_STATISTIC_ENTITY);

        final PlayerStatisticViewModel MOCKED_PLAYER_STATISTIC_VIEW_MODEL = new PlayerStatisticViewModel();
        MOCKED_PLAYER_STATISTIC_VIEW_MODEL.setId(String.valueOf(ID));
        MOCKED_PLAYER_STATISTIC_VIEW_MODEL.setLostMatches(String.valueOf(LOST_MATCHES));
        MOCKED_PLAYER_STATISTIC_VIEW_MODEL.setWinMatches(String.valueOf(WIN_MATCHES));
        MOCKED_PLAYER_STATISTIC_VIEW_MODEL.setDrawMatches(String.valueOf(DRAW_MATCHES));
        MOCKED_PLAYER_STATISTIC_VIEW_MODEL.setGoals(String.valueOf(GOALS));
        MOCKED_PLAYER_STATISTIC_VIEW_MODEL.setKeyPasses(String.valueOf(KEY_PASSES));
        MOCKED_PLAYER_STATISTIC_VIEW_MODEL.setRedCards(String.valueOf(RED_CARDS));
        MOCKED_PLAYER_STATISTIC_VIEW_MODEL.setYellowCards(String.valueOf(YELLOW_CARDS));

        Mockito.when(conversionService.convert(Mockito.any(List.class), Mockito.any(TypeDescriptor.class), Mockito.any(TypeDescriptor.class))).thenReturn(MOCKED_PLAYER_STATISTIC_VIEW_MODEL);

        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/player/statistic/" + ID))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    //.andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(String.valueOf(ID))))
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

        Mockito.verify(playerStatisticService, Mockito.times(1)).findById(ID);
        Mockito.verifyNoMoreInteractions(playerStatisticService);
    }

    @Test
    public void testGetPlayerStatisticByPlayerId() {
        final int PLAYER_ID = 1;
        final int ID  = 1;
        final int LOST_MATCHES = 10;
        final int WIN_MATCHES = 100;
        final int DRAW_MATCHES = 30;
        final int GOALS = 120;
        final int KEY_PASSES = 20;
        final int RED_CARDS = 1;
        final int YELLOW_CARDS = 10;
        final PlayerEntity MOCKED_PLAYER_ENTITY = new PlayerEntity();
        Mockito.when(playerService.findById(ID)).thenReturn(MOCKED_PLAYER_ENTITY);

        final PlayerStatisticViewModel MOCKED_PLAYER_STATISTIC_VIEW_MODEL = new PlayerStatisticViewModel();
        MOCKED_PLAYER_STATISTIC_VIEW_MODEL.setId(String.valueOf(ID));
        MOCKED_PLAYER_STATISTIC_VIEW_MODEL.setLostMatches(String.valueOf(LOST_MATCHES));
        MOCKED_PLAYER_STATISTIC_VIEW_MODEL.setWinMatches(String.valueOf(WIN_MATCHES));
        MOCKED_PLAYER_STATISTIC_VIEW_MODEL.setDrawMatches(String.valueOf(DRAW_MATCHES));
        MOCKED_PLAYER_STATISTIC_VIEW_MODEL.setGoals(String.valueOf(GOALS));
        MOCKED_PLAYER_STATISTIC_VIEW_MODEL.setKeyPasses(String.valueOf(KEY_PASSES));
        MOCKED_PLAYER_STATISTIC_VIEW_MODEL.setRedCards(String.valueOf(RED_CARDS));
        MOCKED_PLAYER_STATISTIC_VIEW_MODEL.setYellowCards(String.valueOf(YELLOW_CARDS));

        Mockito.when(conversionService.convert(Mockito.any(List.class), Mockito.any(TypeDescriptor.class), Mockito.any(TypeDescriptor.class))).thenReturn(MOCKED_PLAYER_STATISTIC_VIEW_MODEL);

        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/player/" + PLAYER_ID + "/statistic"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    //.andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(String.valueOf(ID))))
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
}