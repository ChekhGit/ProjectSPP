package com.spp.chekh.pmfrontend.controller;

import com.spp.chekh.pmbackend.entity.PlayerEntity;
import com.spp.chekh.pmbackend.service.interfaces.PlayerService;
import com.spp.chekh.pmfrontend.view.model.entity.PlayerViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PlayerDataController {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private ConversionService conversionService;

    private final TypeDescriptor playerEntityListTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(PlayerEntity.class));
    private final TypeDescriptor playerViewModelListTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(PlayerViewModel.class));

    @RequestMapping(value ="/player", method = RequestMethod.GET)
    @ResponseBody
    public List<PlayerViewModel> getAllPlayers(){
        List<PlayerEntity> playerEntities = playerService.findAll();
        return (List<PlayerViewModel>) conversionService.convert(playerEntities, playerEntityListTypeDescriptor, playerViewModelListTypeDescriptor);
    }
}
