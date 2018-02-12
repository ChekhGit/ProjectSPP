package com.spp.chekh.pmfrontend.controller;

import com.spp.chekh.pmbackend.service.interfaces.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LeagueDataController {

    @Autowired
    private LeagueService leagueService;
}
