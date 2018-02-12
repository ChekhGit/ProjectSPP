package com.spp.chekh.pmfrontend.controller;

import com.spp.chekh.pmbackend.service.interfaces.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PlayerDataController {

    @Autowired
    private PlayerService playerService;
}
