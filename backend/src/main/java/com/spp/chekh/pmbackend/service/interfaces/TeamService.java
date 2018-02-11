package com.spp.chekh.pmbackend.service.interfaces;

import com.spp.chekh.pmbackend.entity.TeamEntity;

import java.util.List;

public interface TeamService {
    List<TeamEntity> findAll();
    TeamEntity findById(int id);
    TeamEntity save(TeamEntity entity);
    void delete(int id);
}
