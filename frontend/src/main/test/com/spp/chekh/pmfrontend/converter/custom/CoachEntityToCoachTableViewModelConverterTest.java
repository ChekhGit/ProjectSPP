package com.spp.chekh.pmfrontend.converter.custom;

import com.spp.chekh.pmbackend.entity.CoachEntity;
import com.spp.chekh.pmbackend.entity.CoachStatisticEntity;
import com.spp.chekh.pmfrontend.view.model.custom.CoachTableViewModel;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoachEntityToCoachTableViewModelConverterTest {

    @Test
    public void testConvert() {
        final int COACH_ID = 1;
        final String NAME = "TestCoachName";
        final String SURNAME = "TestCoachSurname";
        final int YEARS_OLD = 45;
        final int TEAM_ID = 1;
        final int STATISTIC_ID = 1;
        final CoachEntity MOCKED_COACH_ENTITY = new CoachEntity();
        MOCKED_COACH_ENTITY.setId(COACH_ID);
        MOCKED_COACH_ENTITY.setName(NAME);
        MOCKED_COACH_ENTITY.setSurname(SURNAME);
        MOCKED_COACH_ENTITY.setYearsOld(YEARS_OLD);
        MOCKED_COACH_ENTITY.setIdTeam(TEAM_ID);
        MOCKED_COACH_ENTITY.setIdStatistic(STATISTIC_ID);

        final int TITLES = 3;
        final int WIN_MATCHES = 12;
        final int LOST_MATCHES = 13;
        final int DRAW_MATCHES = 14;
        final CoachStatisticEntity MOCKED_COACH_STATISTIC_ENTITY = new CoachStatisticEntity();
        MOCKED_COACH_STATISTIC_ENTITY.setId(STATISTIC_ID);
        MOCKED_COACH_STATISTIC_ENTITY.setTitles(TITLES);
        MOCKED_COACH_STATISTIC_ENTITY.setWinMatches(WIN_MATCHES);
        MOCKED_COACH_STATISTIC_ENTITY.setLostMatches(LOST_MATCHES);
        MOCKED_COACH_STATISTIC_ENTITY.setDrawMatches(DRAW_MATCHES);
        MOCKED_COACH_ENTITY.setCoachStatisticByIdStatistic(MOCKED_COACH_STATISTIC_ENTITY);

        CoachEntityToCoachTableViewModelConverter coachEntityToCoachTableViewModelConverter = new CoachEntityToCoachTableViewModelConverter();
        CoachTableViewModel coachTableViewModel = coachEntityToCoachTableViewModelConverter.convert(MOCKED_COACH_ENTITY);

        assertNotNull(coachTableViewModel);
        assertEquals(String.valueOf(COACH_ID), coachTableViewModel.getId());
        assertEquals(NAME, coachTableViewModel.getName());
        assertEquals(SURNAME, coachTableViewModel.getSurname());
        assertEquals(String.valueOf(YEARS_OLD), coachTableViewModel.getYearsOld());
        assertEquals(String.valueOf(STATISTIC_ID), coachTableViewModel.getIdStatistic());
        assertEquals(String.valueOf(TITLES), coachTableViewModel.getTitles());
        assertEquals(String.valueOf(WIN_MATCHES), coachTableViewModel.getWinMatches());
        assertEquals(String.valueOf(LOST_MATCHES), coachTableViewModel.getLostMatches());
        assertEquals(String.valueOf(DRAW_MATCHES), coachTableViewModel.getDrawMatches());
    }
}