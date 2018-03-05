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

@Component
public class TeamRosterExcelView extends AbstractXlsView {

    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        Map<String,Object> teamRosterDataMap = (Map<String,Object>) model.get("teamRosterData");
        TeamEntity teamEntity = (TeamEntity) teamRosterDataMap.get("team");
        List<PlayerEntity> playerEntityList = (List<PlayerEntity>) teamRosterDataMap.get("roster");

        HSSFSheet sheet = (HSSFSheet) workbook.createSheet("Team roaster report");
        HSSFRow columns = sheet.createRow(0);
        columns.createCell(0).setCellValue("No.");
        columns.createCell(1).setCellValue("Surname");
        columns.createCell(2).setCellValue("Name");
        columns.createCell(3).setCellValue("Position");
        columns.createCell(4).setCellValue("Win matches");
        columns.createCell(5).setCellValue("Draw matches");
        columns.createCell(6).setCellValue("Lost matches");
        columns.createCell(7).setCellValue("Goals");
        columns.createCell(8).setCellValue("Key passes");
        columns.createCell(9).setCellValue("Yellow cards");
        columns.createCell(10).setCellValue("Red cards");

        int rowNum = 1;
        for (PlayerEntity playerEntity : playerEntityList) {
            HSSFRow row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(rowNum-1);
            row.createCell(1).setCellValue(playerEntity.getSurname());
            row.createCell(2).setCellValue(playerEntity.getName());
            row.createCell(3).setCellValue(playerEntity.getPositionByIdPosition().getName());
            row.createCell(4).setCellValue(playerEntity.getPlayerStatisticByIdPlayerStat().getWinMatches());
            row.createCell(5).setCellValue(playerEntity.getPlayerStatisticByIdPlayerStat().getDrawMatches());
            row.createCell(6).setCellValue(playerEntity.getPlayerStatisticByIdPlayerStat().getLostMatches());
            row.createCell(7).setCellValue(playerEntity.getPlayerStatisticByIdPlayerStat().getGoals());
            row.createCell(8).setCellValue(playerEntity.getPlayerStatisticByIdPlayerStat().getKeyPasses());
            row.createCell(9).setCellValue(playerEntity.getPlayerStatisticByIdPlayerStat().getYellowCards());
            row.createCell(10).setCellValue(playerEntity.getPlayerStatisticByIdPlayerStat().getRedCards());
        }

        String fileName = teamEntity.getName() + " team roster.xls";
        httpServletResponse.setContentType("application/vnd.ms-excel");
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=" + fileName);
    }
}
