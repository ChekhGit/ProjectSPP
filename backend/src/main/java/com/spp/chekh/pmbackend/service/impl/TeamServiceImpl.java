package com.spp.chekh.pmbackend.service.impl;

import com.google.common.collect.Lists;
import com.spp.chekh.pmbackend.entity.TeamEntity;
import com.spp.chekh.pmbackend.repository.TeamRepository;
import com.spp.chekh.pmbackend.service.interfaces.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("jpaTeamService")
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public List<TeamEntity> findAll() {
        return Lists.newArrayList(teamRepository.findAll());
    }

    @Override
    public TeamEntity findById(int id) {
        return teamRepository.findOne(id);
    }

    @Override
    public List<TeamEntity> findByIdLeague(int idLeague) {
        return teamRepository.findByIdLeague(idLeague);
    }

    @Override
    public TeamEntity save(TeamEntity entity) {
        return teamRepository.save(entity);
    }

    @Override
    public void delete(int id) {
        teamRepository.delete(id);
    }
}
