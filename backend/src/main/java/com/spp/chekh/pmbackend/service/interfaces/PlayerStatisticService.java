package com.spp.chekh.pmbackend.service.interfaces;

import com.spp.chekh.pmbackend.entity.PlayerStatisticEntity;

import java.util.List;

public interface PlayerStatisticService {
    List<PlayerStatisticEntity> findAll();
    PlayerStatisticEntity findById(int id);
    PlayerStatisticEntity save(PlayerStatisticEntity entity);
    void delete(int id);
}
