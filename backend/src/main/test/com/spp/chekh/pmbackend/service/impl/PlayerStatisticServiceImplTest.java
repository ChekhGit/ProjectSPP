package com.spp.chekh.pmbackend.service.impl;

import com.spp.chekh.pmbackend.entity.PlayerStatisticEntity;
import com.spp.chekh.pmbackend.repository.PlayerStatisticRepository;
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
public class PlayerStatisticServiceImplTest {

    @InjectMocks
    private PlayerStatisticServiceImpl playerStatisticService;

    @Mock
    private PlayerStatisticRepository playerStatisticRepository;

    @Test
    public void testFindAll() {
        final PlayerStatisticEntity MOCKED_PLAYER_STATISTIC_ENTITY = new PlayerStatisticEntity();
        final List<PlayerStatisticEntity> MOCKED_PLAYER_STATISTIC_ENTITY_LIST = new ArrayList<>();
        MOCKED_PLAYER_STATISTIC_ENTITY_LIST.add(MOCKED_PLAYER_STATISTIC_ENTITY);
        Mockito.doReturn(MOCKED_PLAYER_STATISTIC_ENTITY_LIST).when(playerStatisticRepository).findAll();

        List<PlayerStatisticEntity> coachStatisticEntityList = playerStatisticService.findAll();

        assertNotNull(coachStatisticEntityList);
        assertEquals(MOCKED_PLAYER_STATISTIC_ENTITY_LIST.size(), coachStatisticEntityList.size());
    }

    @Test
    public void testFindById() {
        final int PLAYER_STATISTIC_ID = 1;
        final PlayerStatisticEntity MOCKED_PLAYER_ENTITY = new PlayerStatisticEntity();
        MOCKED_PLAYER_ENTITY.setId(PLAYER_STATISTIC_ID);
        Mockito.doReturn(MOCKED_PLAYER_ENTITY).when(playerStatisticRepository).findOne(PLAYER_STATISTIC_ID);

        PlayerStatisticEntity playerStatisticEntity = playerStatisticService.findById(PLAYER_STATISTIC_ID);

        assertNotNull(playerStatisticEntity);
        assertEquals(PLAYER_STATISTIC_ID, playerStatisticEntity.getId());
    }

    @Test
    public void testFindLast() {
        final PlayerStatisticEntity MOCKED_PLAYER_ENTITY = new PlayerStatisticEntity();
        Mockito.doReturn(MOCKED_PLAYER_ENTITY).when(playerStatisticRepository).findFirstByOrderByIdDesc();

        PlayerStatisticEntity playerStatisticEntity = playerStatisticService.findLast();

        assertNotNull(playerStatisticEntity);
    }
}