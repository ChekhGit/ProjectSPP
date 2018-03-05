package com.spp.chekh.pmbackend.repository;

import com.spp.chekh.pmbackend.entity.TeamEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeamRepository extends CrudRepository<TeamEntity, Integer> {
    List<TeamEntity> findByIdLeague(int idLeague);

    @Query(value = "SELECT * FROM football.team WHERE id_league IN (SELECT id FROM football.league WHERE id_country = ?1)",
            nativeQuery = true)
    List<TeamEntity> findAllByCountryId(int countryId);
}
