package com.spp.chekh.pmfrontend.converter.entity;

import com.spp.chekh.pmbackend.entity.CountryEntity;
import com.spp.chekh.pmfrontend.view.model.entity.CountryViewModel;
import org.junit.Test;

import static org.junit.Assert.*;

public class CountryEntityToCountryViewModelConverterTest {

    @Test
    public void testConvert() {
        final int ID = 1;
        final String NAME = "TestCountryName";
        final CountryEntity MOCKED_COUNTRY_ENTITY = new CountryEntity();
        MOCKED_COUNTRY_ENTITY.setId(ID);
        MOCKED_COUNTRY_ENTITY.setName(NAME);

        CountryEntityToCountryViewModelConverter countryEntityToCountryViewModelConverter = new CountryEntityToCountryViewModelConverter();
        CountryViewModel countryViewModel = countryEntityToCountryViewModelConverter.convert(MOCKED_COUNTRY_ENTITY);

        assertNotNull(countryViewModel);
        assertEquals(String.valueOf(ID), countryViewModel.getId());
        assertEquals(NAME, countryViewModel.getName());
    }
}