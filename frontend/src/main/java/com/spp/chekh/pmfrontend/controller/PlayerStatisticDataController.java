package com.spp.chekh.pmfrontend.controller;

import com.spp.chekh.pmbackend.entity.PlayerEntity;
import com.spp.chekh.pmbackend.entity.PlayerStatisticEntity;
import com.spp.chekh.pmbackend.service.interfaces.PlayerService;
import com.spp.chekh.pmbackend.service.interfaces.PlayerStatisticService;
import com.spp.chekh.pmfrontend.view.model.entity.PlayerStatisticViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PlayerStatisticDataController {

    @Autowired
    private PlayerStatisticService playerStatisticService;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private ConversionService conversionService;

    private final TypeDescriptor playerStatisticEntityTypeDescriptor = TypeDescriptor.valueOf(PlayerStatisticEntity.class);
    private final TypeDescriptor playerStatisticViewModelTypeDescriptor = TypeDescriptor.valueOf(PlayerStatisticViewModel.class);

    private final TypeDescriptor playerStatisticEntityListTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(PlayerStatisticEntity.class));
    private final TypeDescriptor playerStatisticViewModelListTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(PlayerStatisticViewModel.class));

    @RequestMapping(value = "/player/statistic", method = RequestMethod.GET)
    @ResponseBody
    public List<PlayerStatisticViewModel> getAllPlayersStatistics() {
        List<PlayerStatisticEntity> playerStatisticEntityList = playerStatisticService.findAll();
        return (List<PlayerStatisticViewModel>) conversionService.convert(playerStatisticEntityList, playerStatisticEntityListTypeDescriptor, playerStatisticViewModelListTypeDescriptor);
    }

    @RequestMapping(value = "player/statistic/{id}", method = RequestMethod.GET)
    @ResponseBody
    public PlayerStatisticViewModel getPlayerStatisticById(@PathVariable int id) {
        PlayerStatisticEntity playerStatisticEntity = playerStatisticService.findById(id);
        return (PlayerStatisticViewModel) conversionService.convert(playerStatisticEntity, playerStatisticEntityTypeDescriptor, playerStatisticViewModelTypeDescriptor);
    }

    @RequestMapping(value = "/player/{id}/statistic", method = RequestMethod.GET)
    @ResponseBody
    public PlayerStatisticViewModel getPlayerStatisticByPlayerId(@PathVariable int id) {
        PlayerEntity playerEntity = playerService.findById(id);
        return (PlayerStatisticViewModel) conversionService.convert(playerEntity.getPlayerStatisticByIdPlayerStat(), playerStatisticEntityTypeDescriptor, playerStatisticViewModelTypeDescriptor);
    }
}
