package com.spp.chekh.pmfrontend.controller;

import com.spp.chekh.pmbackend.service.interfaces.PlayerStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PlayerStatisticDataController {

    @Autowired
    private PlayerStatisticService playerStatisticService;
}
