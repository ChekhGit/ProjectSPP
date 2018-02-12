package com.spp.chekh.pmfrontend.controller;

import com.spp.chekh.pmbackend.service.interfaces.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CountryDataController {

    @Autowired
    private CountryService countryService;
}
