package com.spp.chekh.pmfrontend.controller;

import com.spp.chekh.pmbackend.entity.PositionEntity;
import com.spp.chekh.pmbackend.service.interfaces.PositionService;
import com.spp.chekh.pmfrontend.view.model.entity.PositionViewModel;
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
public class PositionDataControllerTest {

    private MockMvc mockMvc;

    @Mock
    private PositionService positionService;

    @Mock
    private ConversionService conversionService;

    @InjectMocks
    private PositionDataController positionDataController;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(positionDataController)
                .build();
    }

    @Test
    public void testGetAllPositions() {
        final int ID = 1;
        final String NAME = "TestPositionName";
        final List<PositionEntity> MOCKED_POSITION_ENTITY_LIST = new ArrayList<>();
        Mockito.when(positionService.findAll()).thenReturn(MOCKED_POSITION_ENTITY_LIST);

        final PositionViewModel MOCKED_POSITION_VIEW_MODEL = new PositionViewModel();
        MOCKED_POSITION_VIEW_MODEL.setId(String.valueOf(ID));
        MOCKED_POSITION_VIEW_MODEL.setName(NAME);

        final List<PositionViewModel> MOCKED_POSITION_VIEW_MODEL_LIST = Arrays.asList(MOCKED_POSITION_VIEW_MODEL);
        Mockito.when(conversionService.convert(Mockito.any(List.class), Mockito.any(TypeDescriptor.class), Mockito.any(TypeDescriptor.class))).thenReturn(MOCKED_POSITION_VIEW_MODEL_LIST);

        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/position"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    //.andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", is(String.valueOf(ID))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", is(NAME)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Mockito.verify(positionService, Mockito.times(1)).findAll();
        Mockito.verifyNoMoreInteractions(positionService);
    }

    @Test
    public void testGetPositionById() {
        final int ID = 1;
        final String NAME = "TestPositionName";
        final PositionEntity MOCKED_POSITION_ENTITY = new PositionEntity();
        Mockito.when(positionService.findById(ID)).thenReturn(MOCKED_POSITION_ENTITY);

        final PositionViewModel MOCKED_POSITION_VIEW_MODEL = new PositionViewModel();
        MOCKED_POSITION_VIEW_MODEL.setId(String.valueOf(ID));
        MOCKED_POSITION_VIEW_MODEL.setName(NAME);

        Mockito.when(conversionService.convert(Mockito.any(List.class), Mockito.any(TypeDescriptor.class), Mockito.any(TypeDescriptor.class))).thenReturn(MOCKED_POSITION_VIEW_MODEL);

        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/position/" + ID))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    //.andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(String.valueOf(ID))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.name", is(NAME)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Mockito.verify(positionService, Mockito.times(1)).findById(ID);
        Mockito.verifyNoMoreInteractions(positionService);
    }
}