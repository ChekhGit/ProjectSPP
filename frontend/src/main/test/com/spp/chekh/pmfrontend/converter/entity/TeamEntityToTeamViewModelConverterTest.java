package com.spp.chekh.pmfrontend.converter.entity;

import com.spp.chekh.pmbackend.entity.TeamEntity;
import com.spp.chekh.pmfrontend.view.model.entity.TeamViewModel;
import org.junit.Test;

import static org.junit.Assert.*;

public class TeamEntityToTeamViewModelConverterTest {

    @Test
    public void testConvert() {
        final int ID = 1;
        final String NAME = "TestTeamName";
        final int LEAGUE_ID = 1;

        TeamEntity MOCKED_TEAM_ENTITY = new TeamEntity();
        MOCKED_TEAM_ENTITY.setId(ID);
        MOCKED_TEAM_ENTITY.setName(NAME);
        MOCKED_TEAM_ENTITY.setIdLeague(LEAGUE_ID);

        TeamEntityToTeamViewModelConverter teamEntityToTeamViewModelConverter = new TeamEntityToTeamViewModelConverter();
        TeamViewModel teamViewModel = teamEntityToTeamViewModelConverter.convert(MOCKED_TEAM_ENTITY);

        assertNotNull(teamViewModel);
        assertEquals(String.valueOf(ID), teamViewModel.getId());
        assertEquals(NAME, teamViewModel.getName());
        assertEquals(String.valueOf(LEAGUE_ID), teamViewModel.getIdLeague());
    }
}