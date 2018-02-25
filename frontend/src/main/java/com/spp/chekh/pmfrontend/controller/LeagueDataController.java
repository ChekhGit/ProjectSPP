package com.spp.chekh.pmfrontend.controller;

import com.spp.chekh.pmbackend.entity.LeagueEntity;
import com.spp.chekh.pmbackend.factory.EntityFactory;
import com.spp.chekh.pmbackend.service.interfaces.LeagueService;
import com.spp.chekh.pmbackend.service.interfaces.custom.CreationService;
import com.spp.chekh.pmfrontend.dto.LeagueDTO;
import com.spp.chekh.pmfrontend.view.model.entity.LeagueViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LeagueDataController {

    @Autowired
    private LeagueService leagueService;

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private EntityFactory entityFactory;

    @Autowired
    private CreationService creationService;

    private final TypeDescriptor leagueEntityListTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(LeagueEntity.class));
    private final TypeDescriptor leagueViewModelListTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(LeagueViewModel.class));

    private final TypeDescriptor leagueEntityTypeDescriptor = TypeDescriptor.valueOf(LeagueEntity.class);
    private final TypeDescriptor leagueViewModelTypeDescriptor = TypeDescriptor.valueOf(LeagueViewModel.class);

    @RequestMapping(value = "/league", method = RequestMethod.GET)
    @ResponseBody
    public List<LeagueViewModel> getAllLeagues() {
        List<LeagueEntity> leagueEntities = leagueService.findAll();
        return (List<LeagueViewModel>) conversionService.convert(leagueEntities, leagueEntityListTypeDescriptor, leagueViewModelListTypeDescriptor);
    }

    @RequestMapping(value = "/league/{id}", method = RequestMethod.GET)
    @ResponseBody
    public LeagueViewModel getLeagueById(@PathVariable int id) {
        LeagueEntity leagueEntity = leagueService.findById(id);
        return (LeagueViewModel) conversionService.convert(leagueEntity, leagueEntityTypeDescriptor, leagueViewModelTypeDescriptor);
    }

    @RequestMapping(value = "/country/{id}/league", method = RequestMethod.GET)
    @ResponseBody
    public List<LeagueViewModel> getAllLeaguesByCountryId(@PathVariable int id) {
        List<LeagueEntity> leagueEntities = leagueService.findByIdCountry(id);
        return (List<LeagueViewModel>) conversionService.convert(leagueEntities, leagueEntityListTypeDescriptor, leagueViewModelListTypeDescriptor);
    }

    @RequestMapping(value = "/league/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteLeagueById(@PathVariable int id){
        leagueService.delete(id);
    }

    @RequestMapping(value = "/league", method = RequestMethod.PUT)
    @ResponseBody
    public void createLeague(@RequestBody LeagueDTO leagueDTO){
        LeagueEntity leagueEntity = entityFactory.getLeagueEntity(leagueDTO.getName(), leagueDTO.getCountryId());
        creationService.createLeague(leagueEntity);
    }
}
