package com.spp.chekh.pmbackend.service.impl;

import com.google.common.collect.Lists;
import com.spp.chekh.pmbackend.entity.PositionEntity;
import com.spp.chekh.pmbackend.repository.PositionRepository;
import com.spp.chekh.pmbackend.service.interfaces.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("jpaPositionService")
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionRepository positionRepository;

    @Override
    public List<PositionEntity> findAll() {
        return Lists.newArrayList(positionRepository.findAll());
    }

    @Override
    public PositionEntity findById(int id) {
        return positionRepository.findOne(id);
    }

    @Override
    public PositionEntity save(PositionEntity entity) {
        return positionRepository.save(entity);
    }

    @Override
    public void delete(int id) {
        positionRepository.delete(id);
    }
}
