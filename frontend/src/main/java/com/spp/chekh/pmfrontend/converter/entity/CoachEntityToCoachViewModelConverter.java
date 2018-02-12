package com.spp.chekh.pmfrontend.converter.entity;

import com.spp.chekh.pmbackend.entity.CoachEntity;
import com.spp.chekh.pmfrontend.view.model.entity.CoachViewModel;
import org.springframework.core.convert.converter.Converter;

public class CoachEntityToCoachViewModelConverter implements Converter<CoachEntity, CoachViewModel> {

    @Override
    public CoachViewModel convert(CoachEntity coachEntity) {
        CoachViewModel coachViewModel = new CoachViewModel();
        coachViewModel.setId(String.valueOf(coachEntity.getId()));
        coachViewModel.setName(coachEntity.getName());
        coachViewModel.setSurname(coachEntity.getSurname());
        coachViewModel.setYearsOld(String.valueOf(coachEntity.getYearsOld()));
        coachViewModel.setIdTeam(String.valueOf(coachEntity.getIdTeam()));
        coachViewModel.setIdStatistic(String.valueOf(coachEntity.getIdStatistic()));
        return coachViewModel;
    }
}
