package com.spp.chekh.pmfrontend.controller;

import com.spp.chekh.pmbackend.entity.TeamEntity;
import com.spp.chekh.pmbackend.factory.EntityFactory;
import com.spp.chekh.pmbackend.service.interfaces.TeamService;
import com.spp.chekh.pmbackend.service.interfaces.custom.CreationService;
import com.spp.chekh.pmfrontend.dto.TeamDTO;
import com.spp.chekh.pmfrontend.view.model.entity.TeamViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TeamDataController {

    @Autowired
    private TeamService teamService;

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private EntityFactory entityFactory;

    @Autowired
    private CreationService creationService;

    private final TypeDescriptor teamEntityTypeDescriptor = TypeDescriptor.valueOf(TeamEntity.class);
    private final TypeDescriptor teamViewModelTypeDescriptor = TypeDescriptor.valueOf(TeamViewModel.class);

    private final TypeDescriptor teamEntityListTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(TeamEntity.class));
    private final TypeDescriptor teamViewModelListTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(TeamViewModel.class));

    @RequestMapping(value = "/team", method = RequestMethod.GET)
    @ResponseBody
    public List<TeamViewModel> getAllTeams() {
        List<TeamEntity> teamEntityList = teamService.findAll();
        return (List<TeamViewModel>) conversionService.convert(teamEntityList, teamEntityListTypeDescriptor, teamViewModelListTypeDescriptor);
    }

    @RequestMapping(value = "/team/{id}", method = RequestMethod.GET)
    @ResponseBody
    public TeamViewModel getTeamById(@PathVariable int id) {
        TeamEntity teamEntity = teamService.findById(id);
        return (TeamViewModel) conversionService.convert(teamEntity, teamEntityTypeDescriptor, teamViewModelTypeDescriptor);
    }

    @RequestMapping(value = "/league/{id}/team", method = RequestMethod.GET)
    @ResponseBody
    public List<TeamViewModel> getAllTeamsByLeagueId(@PathVariable int id) {
        List<TeamEntity> teamEntityList = teamService.findByIdLeague(id);
        return (List<TeamViewModel>) conversionService.convert(teamEntityList, teamEntityListTypeDescriptor, teamViewModelListTypeDescriptor);
    }

    @RequestMapping(value = "/team/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteTeamById(@PathVariable int id){
        teamService.delete(id);
    }

    @RequestMapping(value = "/team", method = RequestMethod.PUT)
    @ResponseBody
    public void createTeam(@RequestBody TeamDTO teamDTO){
        TeamEntity teamEntity = entityFactory.getTeamEntity(teamDTO.getName(),0, teamDTO.getLeagueId());
        creationService.createTeam(teamEntity);
    }
}
