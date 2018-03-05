package com.spp.chekh.pmfrontend.controller;

import com.spp.chekh.pmbackend.document.view.*;
import com.spp.chekh.pmbackend.entity.CoachEntity;
import com.spp.chekh.pmbackend.entity.LeagueEntity;
import com.spp.chekh.pmbackend.entity.PlayerEntity;
import com.spp.chekh.pmbackend.entity.TeamEntity;
import com.spp.chekh.pmbackend.service.interfaces.CoachService;
import com.spp.chekh.pmbackend.service.interfaces.LeagueService;
import com.spp.chekh.pmbackend.service.interfaces.PlayerService;
import com.spp.chekh.pmbackend.service.interfaces.TeamService;
import com.spp.chekh.pmfrontend.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DocumentController {

    @Autowired
    private TeamRosterExcelView teamRosterExcelView;

    @Autowired
    private LeagueReportExcelView leagueReportExcelView;

    @Autowired
    private CountryReportExcelView countryReportExcelView;

    @Autowired
    private PlayerReportWordDocView playerReportWordDocView;

    @Autowired
    private CoachReportPDFView coachReportPDFView;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private LeagueService leagueService;

    @Autowired
    private CoachService coachService;

    @RequestMapping(value = "/document/team/{id}/report", method = RequestMethod.GET)
    public ModelAndView generateTeamRosterExcelDocument(@PathVariable int id, HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<PlayerEntity> playerEntities = playerService.findByIdTeam(id);
        TeamEntity teamEntity = teamService.findById(id);

        if(teamEntity == null || playerEntities == null){
            throw new ResourceNotFoundException();
        }

        Map<String, Object> teamRosterData = new HashMap<String, Object>();
        teamRosterData.put("team",teamEntity);
        teamRosterData.put("roster", playerEntities);

        return new ModelAndView(teamRosterExcelView,"teamRosterData", teamRosterData);
    }

    @RequestMapping(value = "/document/league/{id}/report", method = RequestMethod.GET)
    public ModelAndView generateLeagueExcelDocument(@PathVariable int id, HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<PlayerEntity> playerEntities = playerService.findAllByLeagueId(id);
        List<TeamEntity> teamEntities = teamService.findByIdLeague(id);

        if(teamEntities == null || playerEntities == null || teamEntities.isEmpty() || playerEntities.isEmpty()){
            throw new ResourceNotFoundException();
        }

        Map<String, Object> leagueReportData = new HashMap<String, Object>();
        leagueReportData.put("teams", teamEntities);
        leagueReportData.put("players", playerEntities);

        return new ModelAndView(leagueReportExcelView,"leagueReportData", leagueReportData);
    }

    @RequestMapping(value = "/document/country/{id}/report", method = RequestMethod.GET)
    public ModelAndView generateCountryExcelDocument(@PathVariable int id, HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<TeamEntity> teamEntities = teamService.findAllByCountryId(id);
        List<LeagueEntity> leagueEntities = leagueService.findByIdCountry(id);

        if(teamEntities == null || leagueEntities == null || teamEntities.isEmpty() || leagueEntities.isEmpty()){
            throw new ResourceNotFoundException();
        }

        Map<String, Object> countryReportData = new HashMap<String, Object>();
        countryReportData.put("teams", teamEntities);
        countryReportData.put("leagues", leagueEntities);

        return new ModelAndView(countryReportExcelView,"countryReportData", countryReportData);
    }

    @RequestMapping(value = "/document/player/{id}/report", method = RequestMethod.GET)
    public ModelAndView generatePlayerWordDocument(@PathVariable int id, HttpServletRequest request, HttpServletResponse response) throws Exception {

        PlayerEntity playerEntity = playerService.findById(id);

        if(playerEntity == null){
            throw new ResourceNotFoundException();
        }

        Map<String, Object> playerReportData = new HashMap<String, Object>();
        playerReportData.put("player", playerEntity);

        return new ModelAndView(playerReportWordDocView,"playerReportData", playerReportData);
    }

    @RequestMapping(value = "/document/coach/{id}/report", method = RequestMethod.GET)
    public ModelAndView generatePdfFile(@PathVariable int id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        CoachEntity coachEntity = coachService.findById(id);

        if(coachEntity == null){
            throw new ResourceNotFoundException();
        }

        Map<String, Object> coachReportData = new HashMap<String, Object>();
        coachReportData.put("coach", coachEntity);

        return new ModelAndView(coachReportPDFView,"coachReportData", coachReportData);
    }
}
