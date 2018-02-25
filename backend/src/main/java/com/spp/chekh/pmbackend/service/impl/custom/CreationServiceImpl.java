package com.spp.chekh.pmbackend.service.impl.custom;

import com.spp.chekh.pmbackend.entity.*;
import com.spp.chekh.pmbackend.service.interfaces.*;
import com.spp.chekh.pmbackend.service.interfaces.custom.CreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CreationServiceImpl implements CreationService {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private PlayerStatisticService playerStatisticService;

    @Autowired
    private CoachService coachService;

    @Autowired
    private CoachStatisticService coachStatisticService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private LeagueService leagueService;

    @Override
    @Transactional
    public void createCountry(CountryEntity countryEntity) {
        countryService.save(countryEntity);
    }

    @Override
    @Transactional
    public void createLeague(LeagueEntity leagueEntity) {
        leagueService.save(leagueEntity);
    }

    @Override
    @Transactional
    public void createTeam(TeamEntity teamEntity) {
        teamService.save(teamEntity);
    }

    @Override
    @Transactional
    public void createPlayer(PlayerEntity playerEntity, PlayerStatisticEntity playerStatisticEntity) {
        playerStatisticService.save(playerStatisticEntity);
        PlayerStatisticEntity savedPlayerStatisticEntity = playerStatisticService.findLast();
        playerEntity.setIdPlayerStat(savedPlayerStatisticEntity.getId());
        playerEntity.setPlayerStatisticByIdPlayerStat(savedPlayerStatisticEntity);
        playerService.save(playerEntity);
    }

    @Override
    @Transactional
    public void createCoach(CoachEntity coachEntity, CoachStatisticEntity coachStatisticEntity) {
        coachStatisticService.save(coachStatisticEntity);
        CoachStatisticEntity savedCoachStatisticEntity = coachStatisticService.findLast();
        coachEntity.setIdStatistic(savedCoachStatisticEntity.getId());
        coachEntity.setCoachStatisticByIdStatistic(savedCoachStatisticEntity);
        coachService.save(coachEntity);
    }
}
