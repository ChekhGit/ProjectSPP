package com.spp.chekh.pmfrontend.controller;

import com.spp.chekh.pmbackend.entity.PlayerEntity;
import com.spp.chekh.pmbackend.entity.PlayerStatisticEntity;
import com.spp.chekh.pmbackend.factory.EntityFactory;
import com.spp.chekh.pmbackend.service.interfaces.PlayerService;
import com.spp.chekh.pmbackend.service.interfaces.PlayerStatisticService;
import com.spp.chekh.pmbackend.service.interfaces.custom.CreationService;
import com.spp.chekh.pmbackend.service.interfaces.mail.MailService;
import com.spp.chekh.pmfrontend.dto.PlayerDTO;
import com.spp.chekh.pmfrontend.view.model.custom.PlayerTableViewModel;
import com.spp.chekh.pmfrontend.view.model.entity.PlayerViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PlayerDataController {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private PlayerStatisticService playerStatisticService;

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private EntityFactory entityFactory;

    @Autowired
    private CreationService creationService;

    @Autowired
    private MailService mailService;

    private final TypeDescriptor playerEntityListTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(PlayerEntity.class));
    private final TypeDescriptor playerViewModelListTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(PlayerViewModel.class));
    private final TypeDescriptor playerTableViewModelListTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(PlayerTableViewModel.class));
    private final TypeDescriptor playerTableViewModelTypeDescriptor = TypeDescriptor.valueOf(PlayerTableViewModel.class);
    private final TypeDescriptor playerEntityTypeDescriptor = TypeDescriptor.valueOf(PlayerEntity.class);
    private final TypeDescriptor playerViewModelTypeDescriptor = TypeDescriptor.valueOf(PlayerViewModel.class);

    @RequestMapping(value ="/player", method = RequestMethod.GET)
    @ResponseBody
    public List<PlayerViewModel> getAllPlayers(){
        List<PlayerEntity> playerEntities = playerService.findAll();
        return (List<PlayerViewModel>) conversionService.convert(playerEntities, playerEntityListTypeDescriptor, playerViewModelListTypeDescriptor);
    }

    @RequestMapping(value = "/player/{id}", method = RequestMethod.GET)
    @ResponseBody
    public PlayerTableViewModel getPlayerById(@PathVariable int id) {
        PlayerEntity playerEntity = playerService.findById(id);
        return (PlayerTableViewModel) conversionService.convert(playerEntity, playerEntityTypeDescriptor, playerTableViewModelTypeDescriptor);
    }

    @RequestMapping(value ="/team/{id}/player", method = RequestMethod.GET)
    @ResponseBody
    public List<PlayerTableViewModel> getAllPlayersByTeamId(@PathVariable int id){
        List<PlayerEntity> playerEntities = playerService.findByIdTeam(id);
        return (List<PlayerTableViewModel>) conversionService.convert(playerEntities, playerEntityListTypeDescriptor, playerTableViewModelListTypeDescriptor);
    }

    @RequestMapping(value = "/player/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deletePlayerById(@PathVariable int id){
        PlayerEntity playerEntity = playerService.findById(id);
        playerStatisticService.delete(playerEntity.getIdPlayerStat());
        mailService.sendTeamDistribution(playerEntity.getIdTeam());
    }

    @RequestMapping(value = "/player", method = RequestMethod.PUT)
    @ResponseBody
    public void createPlayer(@RequestBody PlayerDTO playerDTO){
        PlayerStatisticEntity playerStatisticEntity = entityFactory.getPlayerStatisticEntity(playerDTO.getWinMatches(),
                playerDTO.getDrawMatches(), playerDTO.getLostMatches(), playerDTO.getGoals(), playerDTO.getKeyPasses(),
                playerDTO.getYellowCards(), playerDTO.getRedCards());

        PlayerEntity playerEntity = entityFactory.getPlayerEntity(playerDTO.getName(),
                playerDTO.getSurname(), playerDTO.getIdTeam(), playerDTO.getIdPosition());

        creationService.createPlayer(playerEntity, playerStatisticEntity);
        mailService.sendTeamDistribution(playerEntity.getIdTeam());
    }
}
