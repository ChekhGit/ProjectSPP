package com.spp.chekh.pmfrontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PageController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String goToHome() {
        return "home";
    }

    @RequestMapping(value = "/statistic", method = RequestMethod.GET)
    public String goToStatPage() {
        return "statView";
    }

    @RequestMapping(value = "/control", method = RequestMethod.GET)
    public String goToAdminPage() {
        return "adminPage";
    }
}