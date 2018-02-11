package com.spp.chekh.pmbackend.service.interfaces;

import com.spp.chekh.pmbackend.entity.PositionEntity;

import java.util.List;

public interface PositionService {
    List<PositionEntity> findAll();
    PositionEntity findById(int id);
    PositionEntity save(PositionEntity entity);
    void delete(int id);
}
