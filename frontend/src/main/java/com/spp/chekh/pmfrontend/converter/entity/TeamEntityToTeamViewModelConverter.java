package com.spp.chekh.pmfrontend.converter.entity;

import com.spp.chekh.pmbackend.entity.TeamEntity;
import com.spp.chekh.pmfrontend.view.model.entity.TeamViewModel;
import org.springframework.core.convert.converter.Converter;

public class TeamEntityToTeamViewModelConverter implements Converter<TeamEntity, TeamViewModel>{
    @Override
    public TeamViewModel convert(TeamEntity teamEntity) {
        TeamViewModel teamViewModel = new TeamViewModel();
        teamViewModel.setId(String.valueOf(teamEntity.getId()));
        teamViewModel.setName(teamEntity.getName());
        teamViewModel.setAmountOfPlayers(String.valueOf(teamEntity.getAmountOfPlayers()));
        teamViewModel.setIdLeague(String.valueOf(teamEntity.getIdLeague()));
        return teamViewModel;
    }
}
