package com.spp.chekh.pmbackend.service.interfaces.document;

import com.spp.chekh.pmbackend.entity.CoachEntity;
import com.spp.chekh.pmbackend.entity.LeagueEntity;
import com.spp.chekh.pmbackend.entity.PlayerEntity;
import com.spp.chekh.pmbackend.entity.TeamEntity;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

public interface DocumentGeneratorService {

    @Async
    void generateCoachPDFReport(CoachEntity coachEntity, int fileId, String realPathToUploads) throws Exception;

    @Async
    void generatePlayerWordReport(PlayerEntity playerEntity, int fileId, String realPathToUploads);

    @Async
    void generateCountryExcelReport(List<LeagueEntity> leagueEntities, List<TeamEntity> teamEntities, int fileId, String realPathToUploads);

    @Async
    void generateLeagueExcelReport(List<TeamEntity> teamEntities, List<PlayerEntity> playerEntities, int fileId, String realPathToUploads);

    @Async
    void generateTeamExcelReport(TeamEntity teamEntity, List<PlayerEntity> playerEntities, int fileId, String realPathToUploads);
}
