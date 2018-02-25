package com.spp.chekh.pmbackend.service.interfaces.custom;

import com.spp.chekh.pmbackend.entity.*;

public interface CreationService {
    void createCountry(CountryEntity countryEntity);
    void createLeague(LeagueEntity leagueEntity);
    void createTeam(TeamEntity teamEntity);
    void createPlayer(PlayerEntity playerEntity, PlayerStatisticEntity playerStatisticEntity);
    void createCoach(CoachEntity coachEntity, CoachStatisticEntity coachStatisticEntity);
}
