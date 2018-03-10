package com.spp.chekh.pmbackend.service.interfaces.mail;

import com.spp.chekh.pmbackend.entity.PlayerEntity;
import org.springframework.scheduling.annotation.Async;

public interface MailService {
    void sendPlayerInfo(PlayerEntity playerEntity, String recipientAddress);
    @Async
    void sendTeamDistribution(int idTeam);
}
