package com.spp.chekh.pmbackend.repository;

import com.spp.chekh.pmbackend.entity.CoachEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CoachRepository extends CrudRepository<CoachEntity, Integer> {
    List<CoachEntity> findByIdTeam(int idTeam);
}
