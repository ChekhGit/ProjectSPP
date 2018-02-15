package com.spp.chekh.pmfrontend.converter.entity;

import com.spp.chekh.pmbackend.entity.CoachStatisticEntity;
import com.spp.chekh.pmfrontend.view.model.entity.CoachStatisticViewModel;
import org.springframework.core.convert.converter.Converter;

public class CoachStatisticEntityToCoachStatisticViewModelConverter implements Converter<CoachStatisticEntity, CoachStatisticViewModel> {
    @Override
    public CoachStatisticViewModel convert(CoachStatisticEntity coachStatisticEntity) {
        CoachStatisticViewModel coachStatisticViewModel = new CoachStatisticViewModel();
        coachStatisticViewModel.setId(String.valueOf(coachStatisticEntity.getId()));
        coachStatisticViewModel.setDrawMatches(String.valueOf(coachStatisticEntity.getDrawMatches()));
        coachStatisticViewModel.setLostMatches(String.valueOf(coachStatisticEntity.getLostMatches()));
        coachStatisticViewModel.setTitles(String.valueOf(coachStatisticEntity.getTitles()));
        coachStatisticViewModel.setWinMatches(String.valueOf(coachStatisticEntity.getWinMatches()));
        return coachStatisticViewModel;
    }
}
