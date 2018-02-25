package com.spp.chekh.pmbackend.service.impl;


import com.google.common.collect.Lists;
import com.spp.chekh.pmbackend.entity.CoachStatisticEntity;
import com.spp.chekh.pmbackend.repository.CoachStatisticRepository;
import com.spp.chekh.pmbackend.service.interfaces.CoachStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("jpaCoachStatisticService")
public class CoachStatisticServiceImpl implements CoachStatisticService{

    @Autowired
    private CoachStatisticRepository coachStatisticRepository;

    @Override
    public List<CoachStatisticEntity> findAll() {
        return Lists.newArrayList(coachStatisticRepository.findAll());
    }

    @Override
    public CoachStatisticEntity findById(int id) {
        return coachStatisticRepository.findOne(id);
    }

    @Override
    public CoachStatisticEntity save(CoachStatisticEntity entity) {
        return coachStatisticRepository.save(entity);
    }

    @Override
    public CoachStatisticEntity findLast() {
        return coachStatisticRepository.findFirstByOrderByIdDesc();
    }

    @Override
    public void delete(int id) {
        coachStatisticRepository.delete(id);
    }
}
