package com.spp.chekh.pmfrontend.converter.custom;

import com.spp.chekh.pmbackend.entity.CoachEntity;
import com.spp.chekh.pmfrontend.view.model.custom.CoachTableViewModel;
import org.springframework.core.convert.converter.Converter;

public class CoachEntityToCoachTableViewModelConverter implements Converter<CoachEntity, CoachTableViewModel> {
    @Override
    public CoachTableViewModel convert(CoachEntity coachEntity) {
        CoachTableViewModel coachTableViewModel = new CoachTableViewModel();
        coachTableViewModel.setId(String.valueOf(coachEntity.getId()));
        coachTableViewModel.setName(coachEntity.getName());
        coachTableViewModel.setSurname(coachEntity.getSurname());
        coachTableViewModel.setYearsOld(String.valueOf(coachEntity.getYearsOld()));
        coachTableViewModel.setIdStatistic(String.valueOf(coachEntity.getIdStatistic()));
        coachTableViewModel.setDrawMatches(String.valueOf(coachEntity.getCoachStatisticByIdStatistic().getDrawMatches()));
        coachTableViewModel.setLostMatches(String.valueOf(coachEntity.getCoachStatisticByIdStatistic().getLostMatches()));
        coachTableViewModel.setTitles(String.valueOf(coachEntity.getCoachStatisticByIdStatistic().getTitles()));
        coachTableViewModel.setWinMatches(String.valueOf(coachEntity.getCoachStatisticByIdStatistic().getWinMatches()));
        return coachTableViewModel;
    }
}
