package com.spp.chekh.pmfrontend.converter.entity;

import com.spp.chekh.pmbackend.entity.CoachEntity;
import com.spp.chekh.pmfrontend.view.model.entity.CoachViewModel;
import org.junit.Test;
import org.springframework.util.StringUtils;

import static org.junit.Assert.*;

public class CoachEntityToCoachViewModelConverterTest {

    @Test
    public void testConvert() {
        final int ID = 1;
        final String NAME = "TestCoachName";
        final String SURNAME = "TestCoachSurname";
        final int YEARS_OLD = 45;
        final int TEAM_ID = 1;
        final int STATISTIC_ID = 1;
        final CoachEntity MOCKED_COACH_ENTITY = new CoachEntity();
        MOCKED_COACH_ENTITY.setId(ID);
        MOCKED_COACH_ENTITY.setName(NAME);
        MOCKED_COACH_ENTITY.setSurname(SURNAME);
        MOCKED_COACH_ENTITY.setYearsOld(YEARS_OLD);
        MOCKED_COACH_ENTITY.setIdTeam(TEAM_ID);
        MOCKED_COACH_ENTITY.setIdStatistic(STATISTIC_ID);

        CoachEntityToCoachViewModelConverter coachEntityToCoachViewModelConverter = new CoachEntityToCoachViewModelConverter();
        CoachViewModel coachViewModel = coachEntityToCoachViewModelConverter.convert(MOCKED_COACH_ENTITY);

        assertNotNull(coachViewModel);
        assertEquals(String.valueOf(ID), coachViewModel.getId());
        assertEquals(NAME, coachViewModel.getName());
        assertEquals(SURNAME, coachViewModel.getSurname());
        assertEquals(String.valueOf(YEARS_OLD), coachViewModel.getYearsOld());
        assertEquals(String.valueOf(TEAM_ID), coachViewModel.getIdTeam());
        assertEquals(String.valueOf(STATISTIC_ID), coachViewModel.getIdStatistic());
    }
}