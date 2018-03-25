package com.spp.chekh.pmfrontend.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PageControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private PageController pageController;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(pageController)
                .build();
    }

    @Test
    public void testGoToHome() {
//        try {
//            mockMvc.perform(MockMvcRequestBuilders.get("/home"))
//                    .andExpect(MockMvcResultMatchers.status().isOk());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    @Test
    public void testGoToStatPage() {
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/statistic"))
                    .andExpect(MockMvcResultMatchers.status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGoToAdminPage() {
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/control"))
                    .andExpect(MockMvcResultMatchers.status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}