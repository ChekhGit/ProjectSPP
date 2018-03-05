package com.spp.chekh.pmbackend.document.view;

import com.spp.chekh.pmbackend.entity.LeagueEntity;
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
public class CountryReportExcelView extends AbstractXlsView {

    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        Map<String,Object> leagueReportDataMap = (Map<String,Object>) model.get("countryReportData");
        List<TeamEntity> teamEntities = (List<TeamEntity>) leagueReportDataMap.get("teams");
        List<LeagueEntity> leagueEntities = (List<LeagueEntity>) leagueReportDataMap.get("leagues");

        String countryName = leagueEntities.get(0).getCountryByIdCountry().getName();

        HSSFSheet sheet = (HSSFSheet) workbook.createSheet("Country report");
        int rowNum = 0;
        HSSFRow header = sheet.createRow(rowNum++);
        header.createCell(0).setCellValue("Country:");
        header.createCell(1).setCellValue(countryName);

        for (LeagueEntity leagueEntity : leagueEntities){
            HSSFRow separatorRow = sheet.createRow(rowNum++);
            for (int i = 0; i < 4; i++){
                separatorRow.createCell(i).setCellValue("---------------");
            }

            HSSFRow leagueRow = sheet.createRow(rowNum++);
            leagueRow.createCell(0).setCellValue("League:");
            leagueRow.createCell(1).setCellValue(leagueEntity.getName());

            HSSFRow teamHeaderRow = sheet.createRow(rowNum++);
            teamHeaderRow.createCell(0).setCellValue("Teams:");

            int leagueId = leagueEntity.getId();
            List<TeamEntity> teamsInLeague = teamEntities.stream().filter(p -> p.getIdLeague() == leagueId).collect(Collectors.toList());
            int teamNum = 1;
            for (TeamEntity teamEntity : teamsInLeague){
                HSSFRow teamRow = sheet.createRow(rowNum++);
                teamRow.createCell(0).setCellValue(teamNum++);
                teamRow.createCell(1).setCellValue(teamEntity.getName());
            }
        }

        String fileName = countryName + " report.xls";
        httpServletResponse.setContentType("application/vnd.ms-excel");
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=" + fileName);
    }
}
