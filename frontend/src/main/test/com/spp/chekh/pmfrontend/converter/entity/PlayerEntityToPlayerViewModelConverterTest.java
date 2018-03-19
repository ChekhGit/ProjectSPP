package com.spp.chekh.pmfrontend.converter.entity;

import com.spp.chekh.pmbackend.entity.PlayerEntity;
import com.spp.chekh.pmfrontend.view.model.entity.PlayerViewModel;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerEntityToPlayerViewModelConverterTest {

    @Test
    public void testConvert() {
        final int ID = 1;
        final String NAME = "TestPlayerName";
        final String SURNAME = "TestPlayerSurname";
        final int TEAM_ID = 1;
        final int STATISTIC_ID = 1;
        final int POSITION_ID = 1;
        final PlayerEntity MOCKED_PLAYER_ENTITY = new PlayerEntity();
        MOCKED_PLAYER_ENTITY.setId(ID);
        MOCKED_PLAYER_ENTITY.setName(NAME);
        MOCKED_PLAYER_ENTITY.setSurname(SURNAME);
        MOCKED_PLAYER_ENTITY.setIdPosition(POSITION_ID);
        MOCKED_PLAYER_ENTITY.setIdTeam(TEAM_ID);
        MOCKED_PLAYER_ENTITY.setIdPlayerStat(STATISTIC_ID);

        PlayerEntityToPlayerViewModelConverter playerEntityToPlayerViewModelConverter = new PlayerEntityToPlayerViewModelConverter();
        PlayerViewModel playerViewModel = playerEntityToPlayerViewModelConverter.convert(MOCKED_PLAYER_ENTITY);

        assertNotNull(playerViewModel);
        assertEquals(String.valueOf(ID), playerViewModel.getId());
        assertEquals(NAME, playerViewModel.getName());
        assertEquals(SURNAME, playerViewModel.getSurname());
        assertEquals(String.valueOf(POSITION_ID), playerViewModel.getIdPosition());
        assertEquals(String.valueOf(TEAM_ID), playerViewModel.getIdTeam());
        assertEquals(String.valueOf(STATISTIC_ID), playerViewModel.getIdPlayerStatistic());
    }
}