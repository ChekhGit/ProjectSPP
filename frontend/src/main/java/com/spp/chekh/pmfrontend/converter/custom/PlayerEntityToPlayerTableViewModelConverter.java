package com.spp.chekh.pmfrontend.converter.custom;

import com.spp.chekh.pmbackend.entity.PlayerEntity;
import com.spp.chekh.pmfrontend.view.model.custom.PlayerTableViewModel;
import org.springframework.core.convert.converter.Converter;

public class PlayerEntityToPlayerTableViewModelConverter implements Converter<PlayerEntity, PlayerTableViewModel> {
    @Override
    public PlayerTableViewModel convert(PlayerEntity playerEntity) {
        PlayerTableViewModel playerTableViewModel = new PlayerTableViewModel();
        playerTableViewModel.setId(String.valueOf(playerEntity.getId()));
        playerTableViewModel.setName(playerEntity.getName());
        playerTableViewModel.setSurname(playerEntity.getSurname());
        playerTableViewModel.setGoals(String.valueOf(playerEntity.getPlayerStatisticByIdPlayerStat().getGoals()));
        playerTableViewModel.setDrawMatches(String.valueOf(playerEntity.getPlayerStatisticByIdPlayerStat().getDrawMatches()));
        playerTableViewModel.setKeyPasses(String.valueOf(playerEntity.getPlayerStatisticByIdPlayerStat().getKeyPasses()));
        playerTableViewModel.setLostMatches(String.valueOf(playerEntity.getPlayerStatisticByIdPlayerStat().getLostMatches()));
        playerTableViewModel.setRedCards(String.valueOf(playerEntity.getPlayerStatisticByIdPlayerStat().getRedCards()));
        playerTableViewModel.setWinMatches(String.valueOf(playerEntity.getPlayerStatisticByIdPlayerStat().getWinMatches()));
        playerTableViewModel.setYellowCards(String.valueOf(playerEntity.getPlayerStatisticByIdPlayerStat().getYellowCards()));
        playerTableViewModel.setPosition(playerEntity.getPositionByIdPosition().getName());
        playerTableViewModel.setIdStatistic(String.valueOf(playerEntity.getIdPlayerStat()));
        return playerTableViewModel;
    }
}
