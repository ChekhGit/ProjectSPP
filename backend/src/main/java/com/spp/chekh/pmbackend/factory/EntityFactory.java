package com.spp.chekh.pmbackend.factory;

import com.spp.chekh.pmbackend.entity.*;
import com.spp.chekh.pmbackend.service.interfaces.CountryService;
import com.spp.chekh.pmbackend.service.interfaces.LeagueService;
import com.spp.chekh.pmbackend.service.interfaces.PositionService;
import com.spp.chekh.pmbackend.service.interfaces.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntityFactory {

    @Autowired
    private TeamService teamService;

    @Autowired
    private PositionService positionService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private LeagueService leagueService;

    public CountryEntity getCountryEntity(String name){
        CountryEntity countryEntity = new CountryEntity();
        countryEntity.setName(name);
        return countryEntity;
    }

    public LeagueEntity getLeagueEntity(String name, int idCountry){
        LeagueEntity leagueEntity = new LeagueEntity();
        leagueEntity.setName(name);
        leagueEntity.setIdCountry(idCountry);
        leagueEntity.setCountryByIdCountry(countryService.findById(idCountry));
        return leagueEntity;
    }

    public TeamEntity getTeamEntity(String name, int amountOfPlayers, int idLeague){
        TeamEntity teamEntity = new TeamEntity();
        teamEntity.setName(name);
        teamEntity.setAmountOfPlayers(amountOfPlayers);
        teamEntity.setIdLeague(idLeague);
        teamEntity.setLeagueByIdLeague(leagueService.findById(idLeague));
        return teamEntity;
    }

    public PlayerStatisticEntity getPlayerStatisticEntity(int winMatches, int drawMatches, int lostMatches, int goals, int keyPasses, int yellowCards, int redCards){
        PlayerStatisticEntity playerStatisticEntity = new PlayerStatisticEntity();
        playerStatisticEntity.setWinMatches(winMatches);
        playerStatisticEntity.setDrawMatches(drawMatches);
        playerStatisticEntity.setLostMatches(lostMatches);
        playerStatisticEntity.setGoals(goals);
        playerStatisticEntity.setKeyPasses(keyPasses);
        playerStatisticEntity.setYellowCards(yellowCards);
        playerStatisticEntity.setRedCards(redCards);
        return playerStatisticEntity;
    }

    public PlayerEntity getPlayerEntity(String name, String surname, int idTeam, int idPosition){
        PlayerEntity playerEntity = new PlayerEntity();
        playerEntity.setName(name);
        playerEntity.setSurname(surname);
        playerEntity.setIdTeam(idTeam);
        playerEntity.setTeamByIdTeam(teamService.findById(idTeam));
        playerEntity.setIdPosition(idPosition);
        playerEntity.setPositionByIdPosition(positionService.findById(idPosition));
        return playerEntity;
    }

    public CoachStatisticEntity getCoachStatisticEntity(int winMatches, int lostMatches, int drawMatches, int titles){
        CoachStatisticEntity coachStatisticEntity = new CoachStatisticEntity();
        coachStatisticEntity.setWinMatches(winMatches);
        coachStatisticEntity.setLostMatches(lostMatches);
        coachStatisticEntity.setDrawMatches(drawMatches);
        coachStatisticEntity.setTitles(titles);
        return coachStatisticEntity;
    }

    public CoachEntity getCoachEntity(String name, String surname, int yearsOld, int idTeam){
        CoachEntity coachEntity = new CoachEntity();
        coachEntity.setName(name);
        coachEntity.setSurname(surname);
        coachEntity.setYearsOld(yearsOld);
        coachEntity.setIdTeam(idTeam);
        coachEntity.setTeamByIdTeam(teamService.findById(idTeam));
        return coachEntity;
    }
}
