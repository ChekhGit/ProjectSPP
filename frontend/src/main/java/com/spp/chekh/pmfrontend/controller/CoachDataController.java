package com.spp.chekh.pmfrontend.controller;

import com.spp.chekh.pmbackend.entity.CoachEntity;
import com.spp.chekh.pmbackend.service.interfaces.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CoachDataController {

    @Autowired
    private CoachService coachService;

    @RequestMapping(value = "/coach", method = RequestMethod.GET)
    @ResponseBody
    public String getAllCoaches() {
        List<CoachEntity> coachEntities = coachService.findAll();
        System.out.println(coachEntities);
        return "test";
    }
}
