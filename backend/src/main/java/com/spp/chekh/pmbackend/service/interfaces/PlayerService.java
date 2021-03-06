package com.spp.chekh.pmbackend.service.interfaces;

import com.spp.chekh.pmbackend.entity.PlayerEntity;

import java.util.List;

public interface PlayerService {
    List<PlayerEntity> findAll();
    PlayerEntity findById(int id);
    List<PlayerEntity> findByIdTeam(int idTeam);
    List<PlayerEntity> findAllByLeagueId(int leagueId);
    PlayerEntity save(PlayerEntity entity);
    void delete(int id);
}
