package com.spp.chekh.pmfrontend.controller;

import com.spp.chekh.pmbackend.service.interfaces.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TeamDataController {

    @Autowired
    private TeamService teamService;
}
