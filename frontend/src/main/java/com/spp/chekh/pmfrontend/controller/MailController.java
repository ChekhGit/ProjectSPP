package com.spp.chekh.pmfrontend.controller;

import com.spp.chekh.pmbackend.entity.PlayerEntity;
import com.spp.chekh.pmbackend.entity.TargetDistributionEntity;
import com.spp.chekh.pmbackend.entity.TeamEntity;
import com.spp.chekh.pmbackend.factory.EntityFactory;
import com.spp.chekh.pmbackend.service.interfaces.PlayerService;
import com.spp.chekh.pmbackend.service.interfaces.TargetDistributionService;
import com.spp.chekh.pmbackend.service.interfaces.TeamService;
import com.spp.chekh.pmbackend.service.interfaces.mail.MailService;
import com.spp.chekh.pmfrontend.dto.MailDTO;
import com.spp.chekh.pmfrontend.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


@Controller
public class MailController {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private MailService mailService;

    @Autowired
    private EntityFactory entityFactory;

    @Autowired
    private TeamService teamService;

    @Autowired
    private TargetDistributionService targetDistributionService;

    @RequestMapping(value = "/player/{id}/mailto", method = RequestMethod.POST)
    @ResponseBody
    public void sendPlayerInfoToEmail(@RequestBody MailDTO mailDTO, @PathVariable int id) {

        PlayerEntity playerEntity = playerService.findById(id);

        if(playerEntity==null || mailDTO==null || StringUtils.isEmpty(mailDTO.getEmail())){
            throw new ResourceNotFoundException();
        }

        mailService.sendPlayerInfo(playerEntity, mailDTO.getEmail());
    }

    @RequestMapping(value = "/team/{id}/distribution", method = RequestMethod.POST)
    @ResponseBody
    public void saveEmailForDistribution(@RequestBody MailDTO mailDTO, @PathVariable int id) {

        TeamEntity teamEntity = teamService.findById(id);

        if(teamEntity==null || mailDTO==null || StringUtils.isEmpty(mailDTO.getEmail())){
            throw new ResourceNotFoundException();
        }

        TargetDistributionEntity targetDistributionEntity = entityFactory.getTargetDistributionEntity(mailDTO.getEmail(), "Team", id);
        targetDistributionService.save(targetDistributionEntity);
    }


}
