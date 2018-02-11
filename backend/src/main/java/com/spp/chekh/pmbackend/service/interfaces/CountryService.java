package com.spp.chekh.pmbackend.service.interfaces;

import com.spp.chekh.pmbackend.entity.CountryEntity;

import java.util.List;

public interface CountryService {
    List<CountryEntity> findAll();
    CountryEntity findById(int id);
    CountryEntity save(CountryEntity entity);
    void delete(int id);
}
