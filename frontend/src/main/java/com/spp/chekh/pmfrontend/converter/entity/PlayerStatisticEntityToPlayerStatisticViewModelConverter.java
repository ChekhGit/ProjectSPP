package com.spp.chekh.pmfrontend.converter.entity;

import com.spp.chekh.pmbackend.entity.PlayerStatisticEntity;
import com.spp.chekh.pmfrontend.view.model.entity.PlayerStatisticViewModel;
import org.springframework.core.convert.converter.Converter;

public class PlayerStatisticEntityToPlayerStatisticViewModelConverter implements Converter<PlayerStatisticEntity, PlayerStatisticViewModel> {
    @Override
    public PlayerStatisticViewModel convert(PlayerStatisticEntity playerStatisticEntity) {
        PlayerStatisticViewModel playerStatisticViewModel = new PlayerStatisticViewModel();
        playerStatisticViewModel.setId(String.valueOf(playerStatisticEntity.getId()));
        playerStatisticViewModel.setDrawMatches(String.valueOf(playerStatisticEntity.getDrawMatches()));
        playerStatisticViewModel.setGoals(String.valueOf(playerStatisticEntity.getGoals()));
        playerStatisticViewModel.setKeyPasses(String.valueOf(playerStatisticEntity.getKeyPasses()));
        playerStatisticViewModel.setLostMatches(String.valueOf(playerStatisticEntity.getLostMatches()));
        playerStatisticViewModel.setRedCards(String.valueOf(playerStatisticEntity.getRedCards()));
        playerStatisticViewModel.setWinMatches(String.valueOf(playerStatisticEntity.getWinMatches()));
        playerStatisticViewModel.setYellowCards(String.valueOf(playerStatisticEntity.getYellowCards()));
        return playerStatisticViewModel;
    }
}
