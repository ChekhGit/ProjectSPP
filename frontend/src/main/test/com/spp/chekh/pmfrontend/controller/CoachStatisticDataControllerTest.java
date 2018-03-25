package com.spp.chekh.pmfrontend.controller;

import com.spp.chekh.pmbackend.entity.CoachEntity;
import com.spp.chekh.pmbackend.entity.CoachStatisticEntity;
import com.spp.chekh.pmbackend.service.interfaces.CoachService;
import com.spp.chekh.pmbackend.service.interfaces.CoachStatisticService;
import com.spp.chekh.pmfrontend.view.model.entity.CoachStatisticViewModel;
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
public class CoachStatisticDataControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CoachStatisticService coachStatisticService;

    @Mock
    private ConversionService conversionService;

    @Mock
    private CoachService coachService;

    @InjectMocks
    private CoachStatisticDataController coachStatisticDataController;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(coachStatisticDataController)
                .build();
    }

    @Test
    public void testGetAllCoachesStatistics() {
        final int ID = 1;
        final int TITLES = 3;
        final int WIN_MATCHES = 12;
        final int LOST_MATCHES = 13;
        final int DRAW_MATCHES = 14;
        final List<CoachStatisticEntity> MOCKED_COACH_STATISTIC_ENTITY_LIST = new ArrayList<>();
        Mockito.when(coachStatisticService.findAll()).thenReturn(MOCKED_COACH_STATISTIC_ENTITY_LIST);

        final CoachStatisticViewModel MOCKED_COACH_STATISTIC_VIEW_MODEL = new CoachStatisticViewModel();
        MOCKED_COACH_STATISTIC_VIEW_MODEL.setId(String.valueOf(ID));
        MOCKED_COACH_STATISTIC_VIEW_MODEL.setWinMatches(String.valueOf(WIN_MATCHES));
        MOCKED_COACH_STATISTIC_VIEW_MODEL.setTitles(String.valueOf(TITLES));
        MOCKED_COACH_STATISTIC_VIEW_MODEL.setDrawMatches(String.valueOf(DRAW_MATCHES));
        MOCKED_COACH_STATISTIC_VIEW_MODEL.setLostMatches(String.valueOf(LOST_MATCHES));

        final List<CoachStatisticViewModel> MOCKED_COACH_STATISTIC_VIEW_MODEL_LIST = Arrays.asList(MOCKED_COACH_STATISTIC_VIEW_MODEL);
        Mockito.when(conversionService.convert(Mockito.any(List.class), Mockito.any(TypeDescriptor.class), Mockito.any(TypeDescriptor.class))).thenReturn(MOCKED_COACH_STATISTIC_VIEW_MODEL_LIST);

        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/coach/statistic"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    //.andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", is(String.valueOf(ID))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].titles", is(String.valueOf(TITLES))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].winMatches", is(String.valueOf(WIN_MATCHES))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].lostMatches", is(String.valueOf(LOST_MATCHES))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].drawMatches", is(String.valueOf(DRAW_MATCHES))));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Mockito.verify(coachStatisticService, Mockito.times(1)).findAll();
        Mockito.verifyNoMoreInteractions(coachStatisticService);
    }

    @Test
    public void testGetCoachStatisticByStatisticId() {
        final int ID = 1;
        final int TITLES = 3;
        final int WIN_MATCHES = 12;
        final int LOST_MATCHES = 13;
        final int DRAW_MATCHES = 14;
        final CoachStatisticEntity MOCKED_COACH_STATISTIC_ENTITY = new CoachStatisticEntity();
        Mockito.when(coachStatisticService.findById(ID)).thenReturn(MOCKED_COACH_STATISTIC_ENTITY);

        final CoachStatisticViewModel MOCKED_COACH_STATISTIC_VIEW_MODEL = new CoachStatisticViewModel();
        MOCKED_COACH_STATISTIC_VIEW_MODEL.setId(String.valueOf(ID));
        MOCKED_COACH_STATISTIC_VIEW_MODEL.setWinMatches(String.valueOf(WIN_MATCHES));
        MOCKED_COACH_STATISTIC_VIEW_MODEL.setTitles(String.valueOf(TITLES));
        MOCKED_COACH_STATISTIC_VIEW_MODEL.setDrawMatches(String.valueOf(DRAW_MATCHES));
        MOCKED_COACH_STATISTIC_VIEW_MODEL.setLostMatches(String.valueOf(LOST_MATCHES));

        Mockito.when(conversionService.convert(Mockito.any(CoachStatisticEntity.class), Mockito.any(TypeDescriptor.class), Mockito.any(TypeDescriptor.class))).thenReturn(MOCKED_COACH_STATISTIC_VIEW_MODEL);

        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/coach/statistic/" + ID))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    //.andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(String.valueOf(ID))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.titles", is(String.valueOf(TITLES))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.winMatches", is(String.valueOf(WIN_MATCHES))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.lostMatches", is(String.valueOf(LOST_MATCHES))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.drawMatches", is(String.valueOf(DRAW_MATCHES))));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Mockito.verify(coachStatisticService, Mockito.times(1)).findById(ID);
        Mockito.verifyNoMoreInteractions(coachStatisticService);
    }

    @Test
    public void testGetCoachStatisticByCoachId() {
        final int COACH_ID = 1;
        final int ID = 1;
        final int TITLES = 3;
        final int WIN_MATCHES = 12;
        final int LOST_MATCHES = 13;
        final int DRAW_MATCHES = 14;
        final CoachEntity MOCKED_COACH_ENTITY = new CoachEntity();
        Mockito.when(coachService.findById(COACH_ID)).thenReturn(MOCKED_COACH_ENTITY);

        final CoachStatisticViewModel MOCKED_COACH_STATISTIC_VIEW_MODEL = new CoachStatisticViewModel();
        MOCKED_COACH_STATISTIC_VIEW_MODEL.setId(String.valueOf(ID));
        MOCKED_COACH_STATISTIC_VIEW_MODEL.setWinMatches(String.valueOf(WIN_MATCHES));
        MOCKED_COACH_STATISTIC_VIEW_MODEL.setTitles(String.valueOf(TITLES));
        MOCKED_COACH_STATISTIC_VIEW_MODEL.setDrawMatches(String.valueOf(DRAW_MATCHES));
        MOCKED_COACH_STATISTIC_VIEW_MODEL.setLostMatches(String.valueOf(LOST_MATCHES));

        Mockito.when(conversionService.convert(Mockito.any(CoachStatisticEntity.class), Mockito.any(TypeDescriptor.class), Mockito.any(TypeDescriptor.class))).thenReturn(MOCKED_COACH_STATISTIC_VIEW_MODEL);

        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/coach/" + COACH_ID  + "/statistic"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                   // .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(String.valueOf(ID))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.titles", is(String.valueOf(TITLES))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.winMatches", is(String.valueOf(WIN_MATCHES))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.lostMatches", is(String.valueOf(LOST_MATCHES))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.drawMatches", is(String.valueOf(DRAW_MATCHES))));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Mockito.verify(coachService, Mockito.times(1)).findById(COACH_ID);
        Mockito.verifyNoMoreInteractions(coachService);
    }
}