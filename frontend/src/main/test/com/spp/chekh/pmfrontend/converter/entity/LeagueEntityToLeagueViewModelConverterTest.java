package com.spp.chekh.pmfrontend.converter.entity;

import com.spp.chekh.pmbackend.entity.LeagueEntity;
import com.spp.chekh.pmfrontend.view.model.entity.LeagueViewModel;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeagueEntityToLeagueViewModelConverterTest {

    @Test
    public void testConvert() {
        final int ID = 1;
        final String NAME = "TestLeagueName";
        final int COUNTRY_ID = 1;

        LeagueEntity MOCKED_LEAGUE_ENTITY = new LeagueEntity();
        MOCKED_LEAGUE_ENTITY.setId(ID);
        MOCKED_LEAGUE_ENTITY.setName(NAME);
        MOCKED_LEAGUE_ENTITY.setIdCountry(COUNTRY_ID);

        LeagueEntityToLeagueViewModelConverter leagueEntityToLeagueViewModelConverter = new LeagueEntityToLeagueViewModelConverter();
        LeagueViewModel leagueViewModel = leagueEntityToLeagueViewModelConverter.convert(MOCKED_LEAGUE_ENTITY);

        assertNotNull(leagueViewModel);
        assertEquals(String.valueOf(ID), leagueViewModel.getId());
        assertEquals(NAME, leagueViewModel.getName());
        assertEquals(String.valueOf(COUNTRY_ID), leagueViewModel.getIdCountry());
    }
}