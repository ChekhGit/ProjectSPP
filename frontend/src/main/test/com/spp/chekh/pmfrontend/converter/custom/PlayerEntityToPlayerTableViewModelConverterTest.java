package com.spp.chekh.pmfrontend.converter.custom;

import com.spp.chekh.pmbackend.entity.PlayerEntity;
import com.spp.chekh.pmbackend.entity.PlayerStatisticEntity;
import com.spp.chekh.pmbackend.entity.PositionEntity;
import com.spp.chekh.pmfrontend.view.model.custom.PlayerTableViewModel;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerEntityToPlayerTableViewModelConverterTest {

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

        final int LOST_MATCHES = 20;
        final int WIN_MATHCES = 100;
        final int DRAW_MATHCES = 10;
        final int GOALS = 120;
        final int KEY_PASSES = 12;
        final int RED_CARDS = 2;
        final int YELLOW_CARDS = 10;
        final PlayerStatisticEntity MOCKED_PLAYER_STATISTIC_ENTITY = new PlayerStatisticEntity();
        MOCKED_PLAYER_STATISTIC_ENTITY.setId(STATISTIC_ID);
        MOCKED_PLAYER_STATISTIC_ENTITY.setWinMatches(WIN_MATHCES);
        MOCKED_PLAYER_STATISTIC_ENTITY.setLostMatches(LOST_MATCHES);
        MOCKED_PLAYER_STATISTIC_ENTITY.setDrawMatches(DRAW_MATHCES);
        MOCKED_PLAYER_STATISTIC_ENTITY.setGoals(GOALS);
        MOCKED_PLAYER_STATISTIC_ENTITY.setKeyPasses(KEY_PASSES);
        MOCKED_PLAYER_STATISTIC_ENTITY.setYellowCards(YELLOW_CARDS);
        MOCKED_PLAYER_STATISTIC_ENTITY.setRedCards(RED_CARDS);
        MOCKED_PLAYER_ENTITY.setPlayerStatisticByIdPlayerStat(MOCKED_PLAYER_STATISTIC_ENTITY);

        final String POSITION_NAME = "TestPositionName";
        final PositionEntity MOCKED_POSITION_ENTITY = new PositionEntity();
        MOCKED_POSITION_ENTITY.setId(POSITION_ID);
        MOCKED_POSITION_ENTITY.setName(POSITION_NAME);
        MOCKED_PLAYER_ENTITY.setPositionByIdPosition(MOCKED_POSITION_ENTITY);

        PlayerEntityToPlayerTableViewModelConverter playerEntityToPlayerTableViewModelConverter = new PlayerEntityToPlayerTableViewModelConverter();
        PlayerTableViewModel playerTableViewModel = playerEntityToPlayerTableViewModelConverter.convert(MOCKED_PLAYER_ENTITY);

        assertNotNull(playerTableViewModel);
        assertEquals(String.valueOf(ID), playerTableViewModel.getId());
        assertEquals(NAME, playerTableViewModel.getName());
        assertEquals(SURNAME, playerTableViewModel.getSurname());
        assertEquals(String.valueOf(STATISTIC_ID), playerTableViewModel.getIdStatistic());
        assertEquals(String.valueOf(LOST_MATCHES), playerTableViewModel.getLostMatches());
        assertEquals(String.valueOf(WIN_MATHCES), playerTableViewModel.getWinMatches());
        assertEquals(String.valueOf(DRAW_MATHCES), playerTableViewModel.getDrawMatches());
        assertEquals(String.valueOf(GOALS), playerTableViewModel.getGoals());
        assertEquals(String.valueOf(KEY_PASSES), playerTableViewModel.getKeyPasses());
        assertEquals(String.valueOf(RED_CARDS), playerTableViewModel.getRedCards());
        assertEquals(String.valueOf(YELLOW_CARDS), playerTableViewModel.getYellowCards());
        assertEquals(POSITION_NAME, playerTableViewModel.getPosition());
    }
}