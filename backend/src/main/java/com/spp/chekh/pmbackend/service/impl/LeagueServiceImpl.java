package com.spp.chekh.pmbackend.service.impl;

import com.google.common.collect.Lists;
import com.spp.chekh.pmbackend.entity.LeagueEntity;
import com.spp.chekh.pmbackend.repository.LeagueRepository;
import com.spp.chekh.pmbackend.service.interfaces.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("jpaLeagueService")
public class LeagueServiceImpl implements LeagueService {

    @Autowired
    private LeagueRepository leagueRepository;

    @Override
    public List<LeagueEntity> findAll() {
        return Lists.newArrayList(leagueRepository.findAll());
    }

    @Override
    public LeagueEntity findById(int id) {
        return leagueRepository.findOne(id);
    }

    @Override
    public LeagueEntity save(LeagueEntity entity) {
        return leagueRepository.save(entity);
    }

    @Override
    public void delete(int id) {
        leagueRepository.delete(id);
    }
}
