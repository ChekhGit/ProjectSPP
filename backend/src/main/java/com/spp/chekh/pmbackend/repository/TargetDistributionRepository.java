package com.spp.chekh.pmbackend.repository;

import com.spp.chekh.pmbackend.entity.TargetDistributionEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TargetDistributionRepository extends CrudRepository<TargetDistributionEntity, Integer> {
    List<TargetDistributionEntity> findByIdTarget(int idTarget);
}
