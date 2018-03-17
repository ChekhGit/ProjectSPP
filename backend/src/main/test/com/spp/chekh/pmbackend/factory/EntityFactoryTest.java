package com.spp.chekh.pmbackend.factory;

import com.spp.chekh.pmbackend.entity.*;
import com.spp.chekh.pmbackend.service.interfaces.CountryService;
import com.spp.chekh.pmbackend.service.interfaces.LeagueService;
import com.spp.chekh.pmbackend.service.interfaces.PositionService;
import com.spp.chekh.pmbackend.service.interfaces.TeamService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;

@RunWith(MockitoJUnitRunner.class)
public class EntityFactoryTest {

    @InjectMocks
    private EntityFactory entityFactory;

    @Mock
    private LeagueService leagueService;

    @Mock
    private CountryService countryService;

    @Mock
    private TeamService teamService;

    @Mock
    private PositionService positionService;

    @Test
    public void testGetCountryEntity() {
        final String NAME = "TestCountryName";
        CountryEntity countryEntity = entityFactory.getCountryEntity(NAME);

        assertNotNull(countryEntity);
        assertEquals(countryEntity.getName(), NAME);
    }

    @Test
    public void testGetLeagueEntity() {
        final String NAME = "TestLeagueName";
        final int COUNTRY_ID = 1;
        final CountryEntity MOCKED_COUNTRY_ENTITY = new CountryEntity();
        Mockito.doReturn(MOCKED_COUNTRY_ENTITY).when(countryService).findById(anyInt());

        LeagueEntity leagueEntity = entityFactory.getLeagueEntity(NAME, COUNTRY_ID);

        assertNotNull(leagueEntity);
        assertEquals(NAME, leagueEntity.getName());
        assertEquals(COUNTRY_ID, leagueEntity.getIdCountry());
    }

    @Test
    public void testGetTeamEntity() {
        final String NAME = "TestTeamName";
        final int LEAGUE_ID = 1;
        final LeagueEntity MOCKED_LEAGUE_ENTITY = new LeagueEntity();
        Mockito.doReturn(MOCKED_LEAGUE_ENTITY).when(leagueService).findById(anyInt());

        TeamEntity teamEntity = entityFactory.getTeamEntity(NAME,20, LEAGUE_ID);

        assertNotNull(teamEntity);
        assertEquals(NAME, teamEntity.getName());
        assertEquals(LEAGUE_ID, teamEntity.getIdLeague());
    }

    @Test
    public void testGetPlayerStatisticEntity() {
        final int WIN_MATCHES = 100;
        final int DRAW_MATCHES = 50;
        final int LOST_MATCHES = 10;
        final int GOALS = 120;
        final int KEY_PASSES = 60;
        final int YELLOW_CARDS = 10;
        final int RED_CARDS = 5;

        PlayerStatisticEntity playerStatisticEntity = entityFactory.getPlayerStatisticEntity(WIN_MATCHES,
                DRAW_MATCHES, LOST_MATCHES, GOALS, KEY_PASSES, YELLOW_CARDS, RED_CARDS);

        assertNotNull(playerStatisticEntity);
        assertEquals(WIN_MATCHES, playerStatisticEntity.getWinMatches());
        assertEquals(DRAW_MATCHES, playerStatisticEntity.getDrawMatches());
        assertEquals(LOST_MATCHES, playerStatisticEntity.getLostMatches());
        assertEquals(GOALS, playerStatisticEntity.getGoals());
        assertEquals(KEY_PASSES, playerStatisticEntity.getKeyPasses());
        assertEquals(YELLOW_CARDS, playerStatisticEntity.getYellowCards());
        assertEquals(RED_CARDS, playerStatisticEntity.getRedCards());
    }

    @Test
    public void testGetPlayerEntity() {
        final String NAME = "TestPlayerName";
        final String SURNAME ="TestPlayerSurname";
        final int TEAM_ID = 1;
        final int POSITION_ID = 1;
        final TeamEntity MOCKED_TEAM_ENTITY = new TeamEntity();
        Mockito.doReturn(MOCKED_TEAM_ENTITY).when(teamService).findById(anyInt());
        final PositionEntity MOCKED_POSITION_ENTITY = new PositionEntity();
        Mockito.doReturn(MOCKED_POSITION_ENTITY).when(positionService).findById(anyInt());

        PlayerEntity playerEntity = entityFactory.getPlayerEntity(NAME, SURNAME, TEAM_ID, POSITION_ID);

        assertNotNull(playerEntity);
        assertEquals(NAME, playerEntity.getName());
        assertEquals(SURNAME, playerEntity.getSurname());
        assertEquals(TEAM_ID, playerEntity.getIdTeam());
        assertEquals(POSITION_ID, playerEntity.getIdPosition());
    }

    @Test
    public void testGetCoachStatisticEntity() {
        final int WIN_MATCHES = 200;
        final int LOST_MATCHES = 50;
        final int DRAW_MATCHES = 10;
        final int TITLES = 15;

        CoachStatisticEntity coachStatisticEntity = entityFactory.getCoachStatisticEntity(WIN_MATCHES,
                LOST_MATCHES, DRAW_MATCHES, TITLES);

        assertNotNull(coachStatisticEntity);
        assertEquals(WIN_MATCHES, coachStatisticEntity.getWinMatches());
        assertEquals(DRAW_MATCHES, coachStatisticEntity.getDrawMatches());
        assertEquals(LOST_MATCHES, coachStatisticEntity.getLostMatches());
        assertEquals(TITLES, coachStatisticEntity.getTitles());
    }

    @Test
    public void testGetCoachEntity() {
        final String NAME = "TestCoachName";
        final String SURNAME = "TestCoachSurname";
        final int YEARS_OLD = 45;
        final int TEAM_ID = 1;
        final TeamEntity MOCKED_TEAM_ENTITY = new TeamEntity();
        Mockito.doReturn(MOCKED_TEAM_ENTITY).when(teamService).findById(anyInt());

        CoachEntity coachEntity = entityFactory.getCoachEntity(NAME, SURNAME, YEARS_OLD, TEAM_ID);

        assertNotNull(coachEntity);
        assertEquals(NAME, coachEntity.getName());
        assertEquals(SURNAME, coachEntity.getSurname());
        assertEquals(YEARS_OLD, coachEntity.getYearsOld());
        assertEquals(TEAM_ID, coachEntity.getIdTeam());
    }

    @Test
    public void testGetFileEntity() {
        final String STATUS = "Ready";
        final String NAME = "TestFileName";
        final String PATH = "/some/path";
        final String TYPE = "xls";

        FileEntity fileEntity = entityFactory.getFileEntity(STATUS, PATH, NAME, TYPE);

        assertNotNull(fileEntity);
        assertEquals(STATUS, fileEntity.getStatus());
        assertEquals(PATH, fileEntity.getPath());
        assertEquals(NAME, fileEntity.getName());
        assertEquals(TYPE, fileEntity.getType());
    }

    @Test
    public void testGetTargetDistributionEntity() {
        final String EMAIL = "test@mail.ru";
        final String TARGET = "team";
        final int TARGET_ID = 1;

        TargetDistributionEntity targetDistributionEntity = entityFactory.getTargetDistributionEntity(EMAIL, TARGET, TARGET_ID);

        assertNotNull(targetDistributionEntity);
        assertEquals(EMAIL, targetDistributionEntity.getEmail());
        assertEquals(TARGET, targetDistributionEntity.getTarget());
        assertEquals(TARGET_ID, targetDistributionEntity.getIdTarget());
    }
}