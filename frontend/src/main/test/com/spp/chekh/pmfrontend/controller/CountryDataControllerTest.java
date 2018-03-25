package com.spp.chekh.pmfrontend.controller;

import com.spp.chekh.pmbackend.entity.CountryEntity;
import com.spp.chekh.pmbackend.service.interfaces.CountryService;
import com.spp.chekh.pmfrontend.view.model.entity.CountryViewModel;
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
public class CountryDataControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ConversionService conversionService;

    @Mock
    private CountryService countryService;

    @InjectMocks
    private CountryDataController countryDataController;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(countryDataController)
                .build();
    }

    @Test
    public void testGetAllCountries() {
        final int ID = 1;
        final String NAME = "TestCountryName";
        final List<CountryEntity> MOCKED_COUNTRY_ENTITY_LIST = new ArrayList<>();
        Mockito.when(countryService.findAll()).thenReturn(MOCKED_COUNTRY_ENTITY_LIST);

        final CountryViewModel MOCKED_COUNTRY_VIEW_MODEL = new CountryViewModel();
        MOCKED_COUNTRY_VIEW_MODEL.setId(String.valueOf(ID));
        MOCKED_COUNTRY_VIEW_MODEL.setName(NAME);

        final List<CountryViewModel> MOCKED_COUNTRY_VIEW_MODEL_LIST = Arrays.asList(MOCKED_COUNTRY_VIEW_MODEL);
        Mockito.when(conversionService.convert(Mockito.any(List.class), Mockito.any(TypeDescriptor.class), Mockito.any(TypeDescriptor.class))).thenReturn(MOCKED_COUNTRY_VIEW_MODEL_LIST);

        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/country"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    //.andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", is(String.valueOf(ID))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", is(NAME)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Mockito.verify(countryService, Mockito.times(1)).findAll();
        Mockito.verifyNoMoreInteractions(countryService);
    }

    @Test
    public void testGetCountryById() {
        final int ID = 1;
        final String NAME = "TestCountryName";
        final CountryEntity MOCKED_COUNTRY_ENTITY = new CountryEntity();
        Mockito.when(countryService.findById(ID)).thenReturn(MOCKED_COUNTRY_ENTITY);

        final CountryViewModel MOCKED_COUNTRY_VIEW_MODEL = new CountryViewModel();
        MOCKED_COUNTRY_VIEW_MODEL.setId(String.valueOf(ID));
        MOCKED_COUNTRY_VIEW_MODEL.setName(NAME);
        Mockito.when(conversionService.convert(Mockito.any(List.class), Mockito.any(TypeDescriptor.class), Mockito.any(TypeDescriptor.class))).thenReturn(MOCKED_COUNTRY_VIEW_MODEL);

        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/country/" + ID))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                    //.andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(String.valueOf(ID))))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.name", is(NAME)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Mockito.verify(countryService, Mockito.times(1)).findById(ID);
        Mockito.verifyNoMoreInteractions(countryService);
    }
}