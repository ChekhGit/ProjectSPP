package com.spp.chekh.pmbackend.service.impl;

import com.google.common.collect.Lists;
import com.spp.chekh.pmbackend.entity.TargetDistributionEntity;
import com.spp.chekh.pmbackend.repository.TargetDistributionRepository;
import com.spp.chekh.pmbackend.service.interfaces.TargetDistributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TargetDistributionServiceImpl implements TargetDistributionService {

    @Autowired
    private TargetDistributionRepository targetDistributionRepository;

    @Override
    public List<TargetDistributionEntity> findAll() {
        return Lists.newArrayList(targetDistributionRepository.findAll());
    }

    @Override
    public TargetDistributionEntity findById(int id) {
        return targetDistributionRepository.findOne(id);
    }

    @Override
    public TargetDistributionEntity save(TargetDistributionEntity entity) {
        return targetDistributionRepository.save(entity);
    }

    @Override
    public List<TargetDistributionEntity> findByIdTarget(int idTarget) {
        return targetDistributionRepository.findByIdTarget(idTarget);
    }

    @Override
    public void delete(int id) {
        targetDistributionRepository.delete(id);
    }
}
