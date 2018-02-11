package com.spp.chekh.pmbackend.service.interfaces;

import com.spp.chekh.pmbackend.entity.CoachStatisticEntity;

import java.util.List;

public interface CoachStatisticService {
    List<CoachStatisticEntity> findAll();
    CoachStatisticEntity findById(int id);
    CoachStatisticEntity save(CoachStatisticEntity entity);
    void delete(int id);
}
