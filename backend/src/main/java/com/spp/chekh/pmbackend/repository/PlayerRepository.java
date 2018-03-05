package com.spp.chekh.pmbackend.repository;

import com.spp.chekh.pmbackend.entity.PlayerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayerRepository extends CrudRepository<PlayerEntity, Integer> {
    List<PlayerEntity> findByIdTeam(int idTeam);

    @Query(value = "SELECT * FROM football.player WHERE id_team IN (SELECT id FROM football.team WHERE id_league = ?1)",
    nativeQuery = true)
    List<PlayerEntity> findAllByLeagueId(int leagueId);
}
