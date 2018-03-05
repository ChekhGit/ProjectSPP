package com.spp.chekh.pmbackend.service.impl;

import com.google.common.collect.Lists;
import com.spp.chekh.pmbackend.entity.PlayerEntity;
import com.spp.chekh.pmbackend.repository.PlayerRepository;
import com.spp.chekh.pmbackend.service.interfaces.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("jpaPlayerService")
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public List<PlayerEntity> findAll() {
        return Lists.newArrayList(playerRepository.findAll());
    }

    @Override
    public PlayerEntity findById(int id) {
        return playerRepository.findOne(id);
    }

    @Override
    public List<PlayerEntity> findByIdTeam(int idTeam) {
        return playerRepository.findByIdTeam(idTeam);
    }

    @Override
    public List<PlayerEntity> findAllByLeagueId(int leagueId) {
        return playerRepository.findAllByLeagueId(leagueId);
    }

    @Override
    public PlayerEntity save(PlayerEntity entity) {
        return playerRepository.save(entity);
    }

    @Override
    public void delete(int id) {
        playerRepository.delete(id);
    }
}
