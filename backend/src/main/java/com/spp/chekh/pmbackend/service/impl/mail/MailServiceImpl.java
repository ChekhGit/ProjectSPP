package com.spp.chekh.pmbackend.service.impl.mail;

import com.spp.chekh.pmbackend.entity.PlayerEntity;
import com.spp.chekh.pmbackend.entity.TargetDistributionEntity;
import com.spp.chekh.pmbackend.service.interfaces.PlayerService;
import com.spp.chekh.pmbackend.service.interfaces.TargetDistributionService;
import com.spp.chekh.pmbackend.service.interfaces.mail.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TargetDistributionService targetDistributionService;

    @Autowired
    private PlayerService playerService;

    public void sendPlayerInfo(PlayerEntity playerEntity, String recipientAddress){

        String subject = "Player information ("+playerEntity.getName()+" "+playerEntity.getSurname() +")";
        String message = playerEntity.getName() + " "
                + playerEntity.getSurname() + "\n"
                + "________________\n"
                + "Information: \n "
                + "Team: " + playerEntity.getTeamByIdTeam().getName() + "\n "
                + "Goals: " + playerEntity.getPlayerStatisticByIdPlayerStat().getGoals() + "\n "
                + "Key passes: " + playerEntity.getPlayerStatisticByIdPlayerStat().getKeyPasses() + "\n "
                + "Win matches: " + playerEntity.getPlayerStatisticByIdPlayerStat().getWinMatches() + "\n "
                + "Draw matches: " + playerEntity.getPlayerStatisticByIdPlayerStat().getDrawMatches() + "\n "
                + "Lost matches: " + playerEntity.getPlayerStatisticByIdPlayerStat().getLostMatches() + "\n "
                + "Yellow cards: " + playerEntity.getPlayerStatisticByIdPlayerStat().getYellowCards() + "\n "
                + "Red cards: " + playerEntity.getPlayerStatisticByIdPlayerStat().getRedCards() + "\n "
                ;

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message);
        try {
            mailSender.send(email);
        }catch (Exception ex){
            System.out.println("Error sending to " + recipientAddress);
        }
    }

    @Async
    public void sendTeamDistribution(int idTeam){

        List<TargetDistributionEntity> targetDistributionEntities = targetDistributionService.findByIdTarget(idTeam);

        List<PlayerEntity> playerEntities = playerService.findByIdTeam(idTeam);
        System.out.println(playerEntities);
        String subject = "Team information ("+playerEntities.get(0).getTeamByIdTeam().getName()+")";
        String message = "New team ("+playerEntities.get(0).getTeamByIdTeam().getName()+") roster:\n";

        for(PlayerEntity playerEntity : playerEntities){
            message += playerEntity.getName() + " " + playerEntity.getSurname() + " " + playerEntity.getPositionByIdPosition().getName() + "\n";
        }

        for(TargetDistributionEntity targetDistributionEntity : targetDistributionEntities){
            SimpleMailMessage email = new SimpleMailMessage();
            email.setTo(targetDistributionEntity.getEmail());
            email.setSubject(subject);
            email.setText(message);
            try {
                mailSender.send(email);
            }catch (Exception ex){
                System.out.println("Error sending to " + targetDistributionEntity.getEmail());
            }
        }
    }
}
