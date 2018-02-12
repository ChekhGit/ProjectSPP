package com.spp.chekh.pmfrontend.converter.entity;

import com.spp.chekh.pmbackend.entity.PositionEntity;
import com.spp.chekh.pmfrontend.view.model.entity.PositionViewModel;
import org.springframework.core.convert.converter.Converter;

public class PositionEntityToPositionViewModelConverter implements Converter<PositionEntity, PositionViewModel> {
    @Override
    public PositionViewModel convert(PositionEntity positionEntity) {
        PositionViewModel positionViewModel = new PositionViewModel();
        positionViewModel.setId(String.valueOf(positionEntity.getId()));
        positionViewModel.setName(positionEntity.getName());
        return positionViewModel;
    }
}
