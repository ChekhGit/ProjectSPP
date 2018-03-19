package com.spp.chekh.pmfrontend.converter.entity;

import com.spp.chekh.pmbackend.entity.CoachEntity;
import com.spp.chekh.pmbackend.entity.CoachStatisticEntity;
import com.spp.chekh.pmfrontend.view.model.entity.CoachStatisticViewModel;
import com.spp.chekh.pmfrontend.view.model.entity.CoachViewModel;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoachStatisticEntityToCoachStatisticViewModelConverterTest {

    @Test
    public void testConvert() {
        final int ID = 1;
        final int TITLES = 3;
        final int WIN_MATCHES = 12;
        final int LOST_MATCHES = 13;
        final int DRAW_MATCHES = 14;
        final CoachStatisticEntity MOCKED_COACH_STATISTIC_ENTITY = new CoachStatisticEntity();
        MOCKED_COACH_STATISTIC_ENTITY.setId(ID);
        MOCKED_COACH_STATISTIC_ENTITY.setTitles(TITLES);
        MOCKED_COACH_STATISTIC_ENTITY.setWinMatches(WIN_MATCHES);
        MOCKED_COACH_STATISTIC_ENTITY.setLostMatches(LOST_MATCHES);
        MOCKED_COACH_STATISTIC_ENTITY.setDrawMatches(DRAW_MATCHES);

        CoachStatisticEntityToCoachStatisticViewModelConverter  coachStatisticEntityToCoachStatisticViewModelConverter = new CoachStatisticEntityToCoachStatisticViewModelConverter();
        CoachStatisticViewModel coachStatisticViewModel = coachStatisticEntityToCoachStatisticViewModelConverter.convert(MOCKED_COACH_STATISTIC_ENTITY);

        assertNotNull(coachStatisticViewModel);
        assertEquals(String.valueOf(ID), coachStatisticViewModel.getId());
        assertEquals(String.valueOf(TITLES), coachStatisticViewModel.getTitles());
        assertEquals(String.valueOf(WIN_MATCHES), coachStatisticViewModel.getWinMatches());
        assertEquals(String.valueOf(LOST_MATCHES), coachStatisticViewModel.getLostMatches());
        assertEquals(String.valueOf(DRAW_MATCHES), coachStatisticViewModel.getDrawMatches());
    }
}