package com.spp.chekh.pmbackend.repository;

import com.spp.chekh.pmbackend.entity.LeagueEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LeagueRepository extends CrudRepository<LeagueEntity, Integer> {
    List<LeagueEntity> findByIdCountry(int idCountry);
}
