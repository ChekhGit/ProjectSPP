package com.spp.chekh.pmfrontend.converter.entity;

import com.spp.chekh.pmbackend.entity.LeagueEntity;
import com.spp.chekh.pmfrontend.view.model.entity.LeagueViewModel;
import org.springframework.core.convert.converter.Converter;

public class LeagueEntityToLeagueViewModelConverter implements Converter<LeagueEntity, LeagueViewModel> {

    @Override
    public LeagueViewModel convert(LeagueEntity leagueEntity) {
        LeagueViewModel leagueViewModel = new LeagueViewModel();
        leagueViewModel.setId(String.valueOf(leagueEntity.getId()));
        leagueViewModel.setName(leagueEntity.getName());
        leagueViewModel.setIdCountry(String.valueOf(leagueEntity.getIdCountry()));
        return leagueViewModel;
    }
}
