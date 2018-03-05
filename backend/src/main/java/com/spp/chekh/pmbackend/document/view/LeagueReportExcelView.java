package com.spp.chekh.pmbackend.document.view;

import com.spp.chekh.pmbackend.entity.PlayerEntity;
import com.spp.chekh.pmbackend.entity.TeamEntity;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class LeagueReportExcelView extends AbstractXlsView {

    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        Map<String,Object> leagueReportDataMap = (Map<String,Object>) model.get("leagueReportData");
        List<TeamEntity> teamEntities = (List<TeamEntity>) leagueReportDataMap.get("teams");
        List<PlayerEntity> playerEntities = (List<PlayerEntity>) leagueReportDataMap.get("players");

        String leagueName = teamEntities.get(0).getLeagueByIdLeague().getName();

        HSSFSheet sheet = (HSSFSheet) workbook.createSheet("League report");
        int rowNum = 0;
        HSSFRow header = sheet.createRow(rowNum++);
        header.createCell(0).setCellValue("League:");
        header.createCell(1).setCellValue(leagueName);

        for (TeamEntity teamEntity : teamEntities){
            HSSFRow separatorRow = sheet.createRow(rowNum++);
            for (int i = 0; i < 4; i++){
                separatorRow.createCell(i).setCellValue("---------------");
            }

            HSSFRow teamRow = sheet.createRow(rowNum++);
            teamRow.createCell(0).setCellValue("Team:");
            teamRow.createCell(1).setCellValue(teamEntity.getName());

            HSSFRow rosterRow = sheet.createRow(rowNum++);
            rosterRow.createCell(0).setCellValue("Roster:");

            int teamId = teamEntity.getId();
            List<PlayerEntity> playersInTeam = playerEntities.stream().filter(p -> p.getIdTeam() == teamId).collect(Collectors.toList());
            int playerNum = 1;
            for (PlayerEntity playerEntity : playersInTeam){
                HSSFRow playerRow = sheet.createRow(rowNum++);
                playerRow.createCell(0).setCellValue(playerNum++);
                playerRow.createCell(1).setCellValue(playerEntity.getSurname());
                playerRow.createCell(2).setCellValue(playerEntity.getName());
                playerRow.createCell(3).setCellValue(playerEntity.getPositionByIdPosition().getName());
            }
        }

        String fileName = leagueName + " report.xls";
        httpServletResponse.setContentType("application/vnd.ms-excel");
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=" + fileName);
    }
}
