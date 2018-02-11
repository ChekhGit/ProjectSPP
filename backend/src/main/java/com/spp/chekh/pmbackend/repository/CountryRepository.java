package com.spp.chekh.pmbackend.repository;

import com.spp.chekh.pmbackend.entity.CountryEntity;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<CountryEntity, Integer> {
}
