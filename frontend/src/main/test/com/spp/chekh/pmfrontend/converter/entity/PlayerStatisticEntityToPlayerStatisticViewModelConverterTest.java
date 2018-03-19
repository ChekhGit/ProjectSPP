package com.spp.chekh.pmfrontend.converter.entity;

import com.spp.chekh.pmbackend.entity.PlayerStatisticEntity;
import com.spp.chekh.pmfrontend.view.model.entity.PlayerStatisticViewModel;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerStatisticEntityToPlayerStatisticViewModelConverterTest {

    @Test
    public void testConvert() {
        final int ID = 1;
        final int LOST_MATCHES = 20;
        final int WIN_MATHCES = 100;
        final int DRAW_MATHCES = 10;
        final int GOALS = 120;
        final int KEY_PASSES = 12;
        final int RED_CARDS = 2;
        final int YELLOW_CARDS = 10;
        final PlayerStatisticEntity MOCKED_PLAYER_STATISTIC_ENTITY = new PlayerStatisticEntity();
        MOCKED_PLAYER_STATISTIC_ENTITY.setId(ID);
        MOCKED_PLAYER_STATISTIC_ENTITY.setWinMatches(WIN_MATHCES);
        MOCKED_PLAYER_STATISTIC_ENTITY.setLostMatches(LOST_MATCHES);
        MOCKED_PLAYER_STATISTIC_ENTITY.setDrawMatches(DRAW_MATHCES);
        MOCKED_PLAYER_STATISTIC_ENTITY.setGoals(GOALS);
        MOCKED_PLAYER_STATISTIC_ENTITY.setKeyPasses(KEY_PASSES);
        MOCKED_PLAYER_STATISTIC_ENTITY.setYellowCards(YELLOW_CARDS);
        MOCKED_PLAYER_STATISTIC_ENTITY.setRedCards(RED_CARDS);
        
        PlayerStatisticEntityToPlayerStatisticViewModelConverter  playerStatisticEntityToPlayerStatisticViewModelConverter = new PlayerStatisticEntityToPlayerStatisticViewModelConverter();
        PlayerStatisticViewModel playerStatisticViewModel = playerStatisticEntityToPlayerStatisticViewModelConverter.convert(MOCKED_PLAYER_STATISTIC_ENTITY);

        assertNotNull(playerStatisticViewModel);
        assertEquals(String.valueOf(ID), playerStatisticViewModel.getId());
        assertEquals(String.valueOf(LOST_MATCHES), playerStatisticViewModel.getLostMatches());
        assertEquals(String.valueOf(WIN_MATHCES), playerStatisticViewModel.getWinMatches());
        assertEquals(String.valueOf(DRAW_MATHCES), playerStatisticViewModel.getDrawMatches());
        assertEquals(String.valueOf(GOALS), playerStatisticViewModel.getGoals());
        assertEquals(String.valueOf(KEY_PASSES), playerStatisticViewModel.getKeyPasses());
        assertEquals(String.valueOf(RED_CARDS), playerStatisticViewModel.getRedCards());
        assertEquals(String.valueOf(YELLOW_CARDS), playerStatisticViewModel.getYellowCards());
    }
}