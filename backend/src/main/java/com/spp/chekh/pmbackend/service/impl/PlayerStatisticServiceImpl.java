package com.spp.chekh.pmbackend.service.impl;

import com.google.common.collect.Lists;
import com.spp.chekh.pmbackend.entity.CoachStatisticEntity;
import com.spp.chekh.pmbackend.entity.PlayerStatisticEntity;
import com.spp.chekh.pmbackend.repository.PlayerStatisticRepository;
import com.spp.chekh.pmbackend.service.interfaces.PlayerStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("jpaPlayerStatisticService")
public class PlayerStatisticServiceImpl implements PlayerStatisticService {

    @Autowired
    private PlayerStatisticRepository playerStatisticRepository;

    @Override
    public List<PlayerStatisticEntity> findAll() {
        return Lists.newArrayList(playerStatisticRepository.findAll());
    }

    @Override
    public PlayerStatisticEntity findById(int id) {
        return playerStatisticRepository.findOne(id);
    }

    @Override
    public PlayerStatisticEntity save(PlayerStatisticEntity entity) {
        return playerStatisticRepository.save(entity);
    }

    @Override
    public PlayerStatisticEntity findLast() {
        return playerStatisticRepository.findFirstByOrderByIdDesc();
    }

    @Override
    public void delete(int id) {
        playerStatisticRepository.delete(id);
    }
}
