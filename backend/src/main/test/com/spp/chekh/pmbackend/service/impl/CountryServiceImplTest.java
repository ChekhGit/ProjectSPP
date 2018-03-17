package com.spp.chekh.pmbackend.service.impl;

import com.spp.chekh.pmbackend.entity.CountryEntity;
import com.spp.chekh.pmbackend.repository.CountryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CountryServiceImplTest {

    @InjectMocks
    private CountryServiceImpl countryService;

    @Mock
    private CountryRepository countryRepository;

    @Test
    public void testFindAll() {
        final CountryEntity MOCKED_COUNTRY_ENTITY = new CountryEntity();
        final List<CountryEntity> MOCKED_COUNTRY_ENTITY_LIST = new ArrayList<>();
        MOCKED_COUNTRY_ENTITY_LIST.add(MOCKED_COUNTRY_ENTITY);
        Mockito.doReturn(MOCKED_COUNTRY_ENTITY_LIST).when(countryRepository).findAll();

        List<CountryEntity> countryEntityList = countryService.findAll();

        assertNotNull(countryEntityList);
        assertEquals(MOCKED_COUNTRY_ENTITY_LIST.size(), countryEntityList.size());
    }

    @Test
    public void testFindById() {
        final int COUNTRY_ID = 1;
        final CountryEntity MOCKED_COUNTRY_ENTITY = new CountryEntity();
        MOCKED_COUNTRY_ENTITY.setId(COUNTRY_ID);
        Mockito.doReturn(MOCKED_COUNTRY_ENTITY).when(countryRepository).findOne(COUNTRY_ID);

        CountryEntity countryEntity= countryService.findById(COUNTRY_ID);

        assertNotNull(countryEntity);
        assertEquals(COUNTRY_ID, countryEntity.getId());
    }
}