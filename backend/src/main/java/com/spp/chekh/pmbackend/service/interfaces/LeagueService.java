package com.spp.chekh.pmbackend.service.interfaces;

import com.spp.chekh.pmbackend.entity.LeagueEntity;

import java.util.List;

public interface LeagueService {
    List<LeagueEntity> findAll();
    LeagueEntity findById(int id);
    List<LeagueEntity> findByIdCountry(int idCountry);
    LeagueEntity save(LeagueEntity entity);
    void delete(int id);
}
