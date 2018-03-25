package com.spp.chekh.pmfrontend.controller;

import com.spp.chekh.pmbackend.entity.CoachEntity;
import com.spp.chekh.pmbackend.service.interfaces.CoachService;
import com.spp.chekh.pmfrontend.view.model.custom.CoachTableViewModel;
import com.spp.chekh.pmfrontend.view.model.entity.CoachViewModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
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
public class CoachDataControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CoachService coachService;

    @Mock
    private ConversionService conversionService;

    @InjectMocks
    private CoachDataController coachDataController;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(coachDataController)
                .build();
    }

    @Test
    public void testGetAllCoaches() {
        final int ID = 1;
        final String NAME = "TestCoachName";
        final String SURNAME = "TestCoachSurname";
        final int YEARS_OLD = 45;
        final int TEAM_ID = 1;
        final int STATISTIC_ID = 1;
        final List<CoachEntity> MOCKED_COACH_ENTITY_LIST = new ArrayList<>();
        Mockito.when(coachService.findAll()).thenReturn(MOCKED_COACH_ENTITY_LIST);

        final CoachViewModel MOCKED_COACH_VIEW_MODEL = new CoachViewModel();
        MOCKED_COACH_VIEW_MODEL.setId(String.valueOf(ID));
        MOCKED_COACH_VIEW_MODEL.setName(NAME);
        MOCKED_COACH_VIEW_MODEL.setSurname(SURNAME);
        MOCKED_COACH_VIEW_MODEL.setIdTeam(String.valueOf(TEAM_ID));
        MOCKED_COACH_VIEW_MODEL.setIdStatistic(String.valueOf(STATISTIC_ID));
        MOCKED_COACH_VIEW_MODEL.setYearsOld(String.valueOf(YEARS_OLD));

        final List<CoachViewModel> COACH_VIEW_MODEL_LIST = Arrays.asList(MOCKED_COACH_VIEW_MODEL);
        Mockito.when(conversionService.convert(Mockito.any(List.class), Mockito.any(TypeDescriptor.class), Mockito.any(TypeDescriptor.class))).thenReturn(COACH_VIEW_MODEL_LIST);

        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/coach"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    //.andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", is(String.valueOf(ID))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", is(NAME)))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].surname", is(SURNAME)))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].yearsOld", is(String.valueOf(YEARS_OLD))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].idTeam", is(String.valueOf(TEAM_ID))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].idStatistic", is(String.valueOf(STATISTIC_ID))));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Mockito.verify(coachService, Mockito.times(1)).findAll();
        Mockito.verifyNoMoreInteractions(coachService);
    }

    @Test
    public void testGetCoachById() {
        final int ID = 1;
        final String NAME = "TestCoachName";
        final String SURNAME = "TestCoachSurname";
        final int YEARS_OLD = 45;
        final int STATISTIC_ID = 1;
        final int WIN_MATCHES = 100;
        final int LOST_MATCHES = 10;
        final int DRAW_MATCHES = 2;
        final int TITLES = 10;
        final CoachEntity MOCKED_COACH_ENTITY = new CoachEntity();

        Mockito.when(coachService.findById(ID)).thenReturn(MOCKED_COACH_ENTITY);

        final CoachTableViewModel MOCKED_COACH_TABLE_VIEW_MODEL = new CoachTableViewModel();
        MOCKED_COACH_TABLE_VIEW_MODEL.setId(String.valueOf(ID));
        MOCKED_COACH_TABLE_VIEW_MODEL.setName(NAME);
        MOCKED_COACH_TABLE_VIEW_MODEL.setSurname(SURNAME);
        MOCKED_COACH_TABLE_VIEW_MODEL.setYearsOld(String.valueOf(YEARS_OLD));
        MOCKED_COACH_TABLE_VIEW_MODEL.setIdStatistic(String.valueOf(STATISTIC_ID));
        MOCKED_COACH_TABLE_VIEW_MODEL.setWinMatches(String.valueOf(WIN_MATCHES));
        MOCKED_COACH_TABLE_VIEW_MODEL.setLostMatches(String.valueOf(LOST_MATCHES));
        MOCKED_COACH_TABLE_VIEW_MODEL.setDrawMatches(String.valueOf(DRAW_MATCHES));
        MOCKED_COACH_TABLE_VIEW_MODEL.setTitles(String.valueOf(TITLES));

        Mockito.when(conversionService.convert(Mockito.eq(MOCKED_COACH_ENTITY), Mockito.any(TypeDescriptor.class), Mockito.any(TypeDescriptor.class))).thenReturn(MOCKED_COACH_TABLE_VIEW_MODEL);

        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/coach/1"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    //.andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(String.valueOf(ID))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.name", is(NAME)))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.surname", is(SURNAME)))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.yearsOld", is(String.valueOf(YEARS_OLD))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.idStatistic", is(String.valueOf(STATISTIC_ID))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.winMatches", is(String.valueOf(WIN_MATCHES))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.lostMatches", is(String.valueOf(LOST_MATCHES))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.drawMatches", is(String.valueOf(DRAW_MATCHES))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.titles", is(String.valueOf(TITLES))));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Mockito.verify(coachService, Mockito.times(1)).findById(ID);
        Mockito.verifyNoMoreInteractions(coachService);
    }

    @Test
    public void testGetAllCoachesByTeamId() {
        final int ID = 1;
        final String NAME = "TestCoachName";
        final String SURNAME = "TestCoachSurname";
        final int YEARS_OLD = 45;
        final int TEAM_ID = 1;
        final int STATISTIC_ID = 1;
        final int WIN_MATCHES = 100;
        final int LOST_MATCHES = 10;
        final int DRAW_MATCHES = 2;
        final int TITLES = 10;
        final CoachEntity MOCKED_COACH_ENTITY = new CoachEntity();

        final List<CoachEntity> MOCKED_COACH_ENTITY_LIST = Arrays.asList(MOCKED_COACH_ENTITY);

        Mockito.when(coachService.findByIdTeam(TEAM_ID)).thenReturn(MOCKED_COACH_ENTITY_LIST);

        final CoachTableViewModel MOCKED_COACH_TABLE_VIEW_MODEL = new CoachTableViewModel();
        MOCKED_COACH_TABLE_VIEW_MODEL.setId(String.valueOf(ID));
        MOCKED_COACH_TABLE_VIEW_MODEL.setName(NAME);
        MOCKED_COACH_TABLE_VIEW_MODEL.setSurname(SURNAME);
        MOCKED_COACH_TABLE_VIEW_MODEL.setYearsOld(String.valueOf(YEARS_OLD));
        MOCKED_COACH_TABLE_VIEW_MODEL.setIdStatistic(String.valueOf(STATISTIC_ID));
        MOCKED_COACH_TABLE_VIEW_MODEL.setWinMatches(String.valueOf(WIN_MATCHES));
        MOCKED_COACH_TABLE_VIEW_MODEL.setLostMatches(String.valueOf(LOST_MATCHES));
        MOCKED_COACH_TABLE_VIEW_MODEL.setDrawMatches(String.valueOf(DRAW_MATCHES));
        MOCKED_COACH_TABLE_VIEW_MODEL.setTitles(String.valueOf(TITLES));

        final List<CoachTableViewModel> MOCKED_COACH_TABLE_VIEW_MODEL_LIST = Arrays.asList(MOCKED_COACH_TABLE_VIEW_MODEL);
        Mockito.when(conversionService.convert(Mockito.eq(MOCKED_COACH_ENTITY_LIST), Mockito.any(TypeDescriptor.class), Mockito.any(TypeDescriptor.class))).thenReturn(MOCKED_COACH_TABLE_VIEW_MODEL_LIST);

        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/team/" + TEAM_ID + "/coach"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                   // .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", is(String.valueOf(ID))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", is(NAME)))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].surname", is(SURNAME)))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].yearsOld", is(String.valueOf(YEARS_OLD))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].idStatistic", is(String.valueOf(STATISTIC_ID))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].winMatches", is(String.valueOf(WIN_MATCHES))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].lostMatches", is(String.valueOf(LOST_MATCHES))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].drawMatches", is(String.valueOf(DRAW_MATCHES))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].titles", is(String.valueOf(TITLES))));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Mockito.verify(coachService, Mockito.times(1)).findByIdTeam(TEAM_ID);
        Mockito.verifyNoMoreInteractions(coachService);
    }
}