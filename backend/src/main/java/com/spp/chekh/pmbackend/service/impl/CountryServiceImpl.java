package com.spp.chekh.pmbackend.service.impl;

import com.google.common.collect.Lists;
import com.spp.chekh.pmbackend.entity.CountryEntity;
import com.spp.chekh.pmbackend.repository.CountryRepository;
import com.spp.chekh.pmbackend.service.interfaces.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("jpaCountryService")
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<CountryEntity> findAll() {
        return Lists.newArrayList(countryRepository.findAll());
    }

    @Override
    public CountryEntity findById(int id) {
        return countryRepository.findOne(id);
    }

    @Override
    public CountryEntity save(CountryEntity entity) {
        return countryRepository.save(entity);
    }

    @Override
    public void delete(int id) {
        countryRepository.delete(id);
    }
}
