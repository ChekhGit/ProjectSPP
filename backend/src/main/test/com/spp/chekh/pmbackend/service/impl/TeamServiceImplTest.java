package com.spp.chekh.pmbackend.service.impl;

import com.spp.chekh.pmbackend.entity.TeamEntity;
import com.spp.chekh.pmbackend.repository.TeamRepository;
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
public class TeamServiceImplTest {

    @InjectMocks
    private TeamServiceImpl teamService;

    @Mock
    private TeamRepository teamRepository;

    @Test
    public void findAll() {
        final TeamEntity MOCKED_TEAM_ENTITY = new TeamEntity();
        final List<TeamEntity> MOCKED_TEAM_ENTITY_LIST = new ArrayList<>();
        MOCKED_TEAM_ENTITY_LIST.add(MOCKED_TEAM_ENTITY);
        Mockito.doReturn(MOCKED_TEAM_ENTITY_LIST).when(teamRepository).findAll();

        List<TeamEntity> teamEntityList = teamService.findAll();

        assertNotNull(teamEntityList);
        assertEquals(MOCKED_TEAM_ENTITY_LIST.size(), teamEntityList.size());
    }

    @Test
    public void findById() {
        final int TEAM_ID = 1;
        final TeamEntity MOCKED_TEAM_ENTITY = new TeamEntity();
        MOCKED_TEAM_ENTITY.setId(TEAM_ID);
        Mockito.doReturn(MOCKED_TEAM_ENTITY).when(teamRepository).findOne(TEAM_ID);

        TeamEntity teamEntity = teamService.findById(TEAM_ID);

        assertNotNull(teamEntity);
        assertEquals(TEAM_ID, teamEntity.getId());
    }

    @Test
    public void findByIdLeague() {
        final int LEAGUE_ID = 1;
        final TeamEntity MOCKED_TEAM_ENTITY = new TeamEntity();
        MOCKED_TEAM_ENTITY.setIdLeague(LEAGUE_ID);
        final List<TeamEntity> MOCKED_TEAM_ENTITY_LIST = new ArrayList<>();
        MOCKED_TEAM_ENTITY_LIST.add(MOCKED_TEAM_ENTITY);
        Mockito.doReturn(MOCKED_TEAM_ENTITY_LIST).when(teamRepository).findByIdLeague(LEAGUE_ID);

        List<TeamEntity> teamEntityList = teamService.findByIdLeague(LEAGUE_ID);

        assertNotNull(teamEntityList);
        assertEquals(MOCKED_TEAM_ENTITY_LIST.size(), teamEntityList.size());
        assertEquals(LEAGUE_ID, teamEntityList.get(0).getIdLeague());
    }

    @Test
    public void findAllByCountryId() {
        final int COUNTRY_ID = 1;
        final TeamEntity MOCKED_TEAM_ENTITY = new TeamEntity();
        final List<TeamEntity> MOCKED_TEAM_ENTITY_LIST = new ArrayList<>();
        MOCKED_TEAM_ENTITY_LIST.add(MOCKED_TEAM_ENTITY);
        Mockito.doReturn(MOCKED_TEAM_ENTITY_LIST).when(teamRepository).findAllByCountryId(COUNTRY_ID);

        List<TeamEntity> teamEntityList = teamService.findAllByCountryId(COUNTRY_ID);

        assertNotNull(teamEntityList);
        assertEquals(MOCKED_TEAM_ENTITY_LIST.size(), teamEntityList.size());
    }
}