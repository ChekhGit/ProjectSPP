package com.spp.chekh.pmbackend.service.interfaces;

import com.spp.chekh.pmbackend.entity.TargetDistributionEntity;

import java.util.List;

public interface TargetDistributionService {
    List<TargetDistributionEntity> findAll();
    TargetDistributionEntity findById(int id);
    TargetDistributionEntity save(TargetDistributionEntity entity);
    List<TargetDistributionEntity> findByIdTarget(int idTarget);
    void delete(int id);
}
