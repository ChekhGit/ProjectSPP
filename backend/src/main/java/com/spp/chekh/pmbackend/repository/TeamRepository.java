package com.spp.chekh.pmbackend.repository;

import com.spp.chekh.pmbackend.entity.TeamEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeamRepository extends CrudRepository<TeamEntity, Integer> {
    List<TeamEntity> findByIdLeague(int idLeague);
}
