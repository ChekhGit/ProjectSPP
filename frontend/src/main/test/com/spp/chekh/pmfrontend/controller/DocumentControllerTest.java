package com.spp.chekh.pmfrontend.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class DocumentControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private DocumentController documentController;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(documentController)
                .build();
    }

    @Test
    public void testGenerateTeamRosterExcelDocument() {
    }

    @Test
    public void testGenerateLeagueExcelDocument() {
    }

    @Test
    public void testGenerateCountryExcelDocument() {
    }

    @Test
    public void testGeneratePlayerWordDocument() {
    }

    @Test
    public void testGeneratePdfFile() {
    }

    @Test
    public void testCheckDocument() {
    }
}