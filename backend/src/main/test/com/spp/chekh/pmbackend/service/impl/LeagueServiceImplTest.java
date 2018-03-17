package com.spp.chekh.pmbackend.service.impl;

import com.spp.chekh.pmbackend.entity.LeagueEntity;
import com.spp.chekh.pmbackend.repository.LeagueRepository;
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
public class LeagueServiceImplTest {

    @InjectMocks
    private LeagueServiceImpl leagueService;

    @Mock
    private LeagueRepository leagueRepository;

    @Test
    public void testFindAll() {
        final LeagueEntity MOCKED_LEAGUE_ENTITY = new LeagueEntity();
        final List<LeagueEntity> MOCKED_LEAGUE_ENTITY_LIST = new ArrayList<>();
        MOCKED_LEAGUE_ENTITY_LIST.add(MOCKED_LEAGUE_ENTITY);
        Mockito.doReturn(MOCKED_LEAGUE_ENTITY_LIST).when(leagueRepository).findAll();

        List<LeagueEntity> leagueEntityList = leagueService.findAll();

        assertNotNull(leagueEntityList);
        assertEquals(MOCKED_LEAGUE_ENTITY_LIST.size(), leagueEntityList.size());
    }

    @Test
    public void testFindById() {
        final int LEAGUE_ID = 1;
        final LeagueEntity MOCKED_LEAGUE_ENTITY = new LeagueEntity();
        MOCKED_LEAGUE_ENTITY.setId(LEAGUE_ID);
        Mockito.doReturn(MOCKED_LEAGUE_ENTITY).when(leagueRepository).findOne(LEAGUE_ID);

        LeagueEntity leagueEntity = leagueService.findById(LEAGUE_ID);

        assertNotNull(leagueEntity);
        assertEquals(LEAGUE_ID, leagueEntity.getId());
    }

    @Test
    public void testFindByIdCountry() {
        final int COUNTRY_ID = 1;
        final LeagueEntity MOCKED_LEAGUE_ENTITY = new LeagueEntity();
        MOCKED_LEAGUE_ENTITY.setIdCountry(COUNTRY_ID);
        final List<LeagueEntity> MOCKED_LEAGUE_ENTITY_LIST = new ArrayList<>();
        MOCKED_LEAGUE_ENTITY_LIST.add(MOCKED_LEAGUE_ENTITY);
        Mockito.doReturn(MOCKED_LEAGUE_ENTITY_LIST).when(leagueRepository).findByIdCountry(COUNTRY_ID);

        List<LeagueEntity> leagueEntityList = leagueService.findByIdCountry(COUNTRY_ID);

        assertNotNull(leagueEntityList);
        assertEquals(MOCKED_LEAGUE_ENTITY_LIST.size(), leagueEntityList.size());
        assertEquals(COUNTRY_ID, leagueEntityList.get(0).getIdCountry());
    }
}