package com.spp.chekh.pmbackend.service.impl;

import com.google.common.collect.Lists;
import com.spp.chekh.pmbackend.entity.CoachEntity;
import com.spp.chekh.pmbackend.repository.CoachRepository;
import com.spp.chekh.pmbackend.service.interfaces.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("jpaCoachService")
public class CoachServiceImpl implements CoachService {

    @Autowired
    private CoachRepository coachRepository;

    @Override
    public List<CoachEntity> findAll() {
        return Lists.newArrayList(coachRepository.findAll());
    }

    @Override
    public CoachEntity findById(int id) {
        return coachRepository.findOne(id);
    }

    @Override
    public List<CoachEntity> findByIdTeam(int idTeam) {
        return coachRepository.findByIdTeam(idTeam);
    }

    @Override
    public CoachEntity save(CoachEntity entity) {
        return coachRepository.save(entity);
    }

    @Override
    public void delete(int id) {
        coachRepository.delete(id);
    }
}
