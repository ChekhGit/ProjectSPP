package com.spp.chekh.pmbackend.service.interfaces;

import com.spp.chekh.pmbackend.entity.CoachEntity;

import java.util.List;

public interface CoachService {
    List<CoachEntity> findAll();
    CoachEntity findById(int id);
    List<CoachEntity> findByIdTeam(int idTeam);
    CoachEntity save(CoachEntity entity);
    void delete(int id);
}
