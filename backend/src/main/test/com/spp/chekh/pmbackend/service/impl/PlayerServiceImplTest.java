package com.spp.chekh.pmbackend.service.impl;

import com.spp.chekh.pmbackend.entity.PlayerEntity;
import com.spp.chekh.pmbackend.repository.PlayerRepository;
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
public class PlayerServiceImplTest {

    @InjectMocks
    private PlayerServiceImpl playerService;

    @Mock
    private PlayerRepository playerRepository;

    @Test
    public void testFindAll() {
        final PlayerEntity MOCKED_PLAYER_ENTITY = new PlayerEntity();
        final List<PlayerEntity> MOCKED_PLAYER_ENTITY_LIST = new ArrayList<>();
        MOCKED_PLAYER_ENTITY_LIST.add(MOCKED_PLAYER_ENTITY);
        Mockito.doReturn(MOCKED_PLAYER_ENTITY_LIST).when(playerRepository).findAll();

        List<PlayerEntity> playerEntityList = playerService.findAll();

        assertNotNull(playerEntityList);
        assertEquals(MOCKED_PLAYER_ENTITY_LIST.size(), playerEntityList.size());
    }

    @Test
    public void testFindById() {
        final int PLAYER_ID = 1;
        final PlayerEntity MOCKED_PLAYER_ENTITY = new PlayerEntity();
        MOCKED_PLAYER_ENTITY.setId(PLAYER_ID);
        Mockito.doReturn(MOCKED_PLAYER_ENTITY).when(playerRepository).findOne(PLAYER_ID);

        PlayerEntity playerEntity = playerService.findById(PLAYER_ID);

        assertNotNull(playerEntity);
        assertEquals(PLAYER_ID, playerEntity.getId());
    }

    @Test
    public void testFindByIdTeam() {
        final int TEAM_ID = 1;
        final PlayerEntity MOCKED_PLAYER_ENTITY = new PlayerEntity();
        MOCKED_PLAYER_ENTITY.setIdTeam(TEAM_ID);
        final List<PlayerEntity> MOCKED_PLAYER_ENTITY_LIST = new ArrayList<>();
        MOCKED_PLAYER_ENTITY_LIST.add(MOCKED_PLAYER_ENTITY);
        Mockito.doReturn(MOCKED_PLAYER_ENTITY_LIST).when(playerRepository).findByIdTeam(TEAM_ID);

        List<PlayerEntity> playerEntityList = playerService.findByIdTeam(TEAM_ID);

        assertNotNull(playerEntityList);
        assertEquals(MOCKED_PLAYER_ENTITY_LIST.size(), playerEntityList.size());
        assertEquals(TEAM_ID, playerEntityList.get(0).getIdTeam());
    }

    @Test
    public void testFindAllByLeagueId() {
        final int LEAGUE_ID = 1;
        final PlayerEntity MOCKED_PLAYER_ENTITY = new PlayerEntity();
        final List<PlayerEntity> MOCKED_PLAYER_ENTITY_LIST = new ArrayList<>();
        MOCKED_PLAYER_ENTITY_LIST.add(MOCKED_PLAYER_ENTITY);
        Mockito.doReturn(MOCKED_PLAYER_ENTITY_LIST).when(playerRepository).findAllByLeagueId(LEAGUE_ID);

        List<PlayerEntity> playerEntityList = playerService.findAllByLeagueId(LEAGUE_ID);

        assertNotNull(playerEntityList);
        assertEquals(MOCKED_PLAYER_ENTITY_LIST.size(), playerEntityList.size());
    }
}