package com.spp.chekh.pmbackend.repository;

import com.spp.chekh.pmbackend.entity.CoachStatisticEntity;
import org.springframework.data.repository.CrudRepository;

public interface CoachStatisticRepository extends CrudRepository<CoachStatisticEntity, Integer> {
    CoachStatisticEntity findFirstByOrderByIdDesc();
}
