package com.spp.chekh.pmfrontend.converter.entity;

import com.spp.chekh.pmbackend.entity.CountryEntity;
import com.spp.chekh.pmfrontend.view.model.entity.CountryViewModel;
import org.springframework.core.convert.converter.Converter;

public class CountryEntityToCountryViewModelConverter implements Converter<CountryEntity, CountryViewModel> {
    @Override
    public CountryViewModel convert(CountryEntity countryEntity) {
        CountryViewModel countryViewModel = new CountryViewModel();
        countryViewModel.setId(String.valueOf(countryEntity.getId()));
        countryViewModel.setName(countryEntity.getName());
        countryViewModel.setUrl(countryEntity.getUrl());
        return countryViewModel;
    }
}
