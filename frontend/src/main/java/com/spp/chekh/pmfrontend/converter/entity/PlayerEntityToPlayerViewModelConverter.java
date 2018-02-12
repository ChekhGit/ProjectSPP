package com.spp.chekh.pmfrontend.converter.entity;

import com.spp.chekh.pmbackend.entity.PlayerEntity;
import com.spp.chekh.pmfrontend.view.model.entity.PlayerViewModel;
import org.springframework.core.convert.converter.Converter;

public class PlayerEntityToPlayerViewModelConverter implements Converter<PlayerEntity, PlayerViewModel> {
    @Override
    public PlayerViewModel convert(PlayerEntity playerEntity) {
        PlayerViewModel playerViewModel = new PlayerViewModel();
        playerViewModel.setId(String.valueOf(playerEntity.getId()));
        playerViewModel.setName(playerEntity.getName());
        playerViewModel.setSurname(playerEntity.getSurname());
        playerViewModel.setIdTeam(String.valueOf(playerEntity.getIdTeam()));
        playerViewModel.setIdPosition(String.valueOf(playerEntity.getIdPosition()));
        playerViewModel.setIdPlayerStatistic(String.valueOf(playerEntity.getIdPlayerStat()));
        return playerViewModel;
    }
}
