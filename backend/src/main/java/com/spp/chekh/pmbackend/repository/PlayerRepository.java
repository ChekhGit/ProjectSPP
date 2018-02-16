package com.spp.chekh.pmbackend.repository;

import com.spp.chekh.pmbackend.entity.PlayerEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayerRepository extends CrudRepository<PlayerEntity, Integer> {
    List<PlayerEntity> findByIdTeam(int idTeam);
}
