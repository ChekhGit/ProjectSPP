package com.spp.chekh.pmbackend.service.impl.document;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.spp.chekh.pmbackend.entity.*;
import com.spp.chekh.pmbackend.factory.EntityFactory;
import com.spp.chekh.pmbackend.service.interfaces.FileService;
import com.spp.chekh.pmbackend.service.interfaces.document.DocumentGeneratorService;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentGeneratorServiceImpl implements DocumentGeneratorService {

    @Autowired
    private FileService fileService;

    @Autowired
    private EntityFactory entityFactory;

    @Async
    public void generateCoachPDFReport(CoachEntity coachEntity, int fileId, String realPathToUploads) throws Exception{

        ByteArrayOutputStream baos = new ByteArrayOutputStream(4096);
        Document document = new Document(PageSize.A4);
        PdfWriter writer = PdfWriter.getInstance(document, baos);
        writer.setViewerPreferences(2053);
        document.open();

        Table table = new Table(2);
        table.addCell("Name");
        table.addCell(coachEntity.getName());
        table.addCell("Surname");
        table.addCell(coachEntity.getSurname());
        table.addCell("Team:");
        table.addCell(coachEntity.getTeamByIdTeam().getName());
        table.addCell("League:");
        table.addCell(coachEntity.getTeamByIdTeam().getLeagueByIdLeague().getName());
        table.addCell("Years old");
        table.addCell(String.valueOf(coachEntity.getYearsOld()));
        table.addCell("Win matches");
        table.addCell(String.valueOf(coachEntity.getCoachStatisticByIdStatistic().getWinMatches()));
        table.addCell("Lost matches");
        table.addCell(String.valueOf(coachEntity.getCoachStatisticByIdStatistic().getLostMatches()));
        table.addCell("Draw matches");
        table.addCell(String.valueOf(coachEntity.getCoachStatisticByIdStatistic().getDrawMatches()));
        table.addCell("Titles");
        table.addCell(String.valueOf(coachEntity.getCoachStatisticByIdStatistic().getTitles()));
        document.add(table);

        document.close();

        String fileName = coachEntity.getName()+ coachEntity.getSurname() + "Report.pdf";

        if(! new File(realPathToUploads).exists())
        {
            new File(realPathToUploads).mkdir();
        }

        String filePath = realPathToUploads + fileName;
        File dest = new File(filePath);

        FileOutputStream fo = null;
        try {
            fo = new FileOutputStream(dest);
            baos.writeTo(fo);
        } catch (IOException e) {
        } finally {
            if (fo != null) {
                try {
                    fo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        FileEntity fileEntity = entityFactory.getFileEntity("Ready", filePath, fileName, "pdf");
        fileEntity.setId(fileId);
        fileService.save(fileEntity);

    }

    @Async
    public void generatePlayerWordReport(PlayerEntity playerEntity, int fileId, String realPathToUploads){
        XWPFDocument xwpfDocument = new XWPFDocument();
        XWPFParagraph p1 = xwpfDocument.createParagraph();
        p1.setFirstLineIndent(400);
        p1.setAlignment(ParagraphAlignment.LEFT);
        p1.setWordWrapped(true);
        XWPFRun r1 = p1.createRun();
        String t1 = "Player: " + playerEntity.getName() + " " + playerEntity.getSurname();
        r1.setText(t1);
        r1.addBreak();
        String t2 = "Team: " + playerEntity.getTeamByIdTeam().getName();
        r1.setText(t2);
        r1.addBreak();
        String t3 = "League: " + playerEntity.getTeamByIdTeam().getLeagueByIdLeague().getName();
        r1.setText(t3);
        r1.addBreak();

        String t4 = "Player statistic: ";
        r1.setText(t4);
        r1.addBreak();
        String t5 = "Win matches: " + playerEntity.getPlayerStatisticByIdPlayerStat().getWinMatches();
        r1.setText(t5);
        r1.addBreak();
        String t6 = "Lost matches: " + playerEntity.getPlayerStatisticByIdPlayerStat().getLostMatches();
        r1.setText(t6);
        r1.addBreak();
        String t7 = "Draw matches: " + playerEntity.getPlayerStatisticByIdPlayerStat().getDrawMatches();
        r1.setText(t7);
        r1.addBreak();
        String t8 = "Goals: " + playerEntity.getPlayerStatisticByIdPlayerStat().getGoals();
        r1.setText(t8);
        r1.addBreak();
        String t9 = "Key passes: " + playerEntity.getPlayerStatisticByIdPlayerStat().getKeyPasses();
        r1.setText(t9);
        r1.addBreak();
        String t10 = "Yellow cards: " + playerEntity.getPlayerStatisticByIdPlayerStat().getYellowCards();
        r1.setText(t10);
        r1.addBreak();
        String t11 = "Red cards: " + playerEntity.getPlayerStatisticByIdPlayerStat().getRedCards();
        r1.setText(t11);
        r1.addBreak();

        String fileName = playerEntity.getName() + playerEntity.getSurname() + "Report.docx";

        if(! new File(realPathToUploads).exists())
        {
            new File(realPathToUploads).mkdir();
        }

        String filePath = realPathToUploads + fileName;
        File dest = new File(filePath);

        FileOutputStream fo = null;
        try {
            fo = new FileOutputStream(dest);
            xwpfDocument.write(fo);
        } catch (IOException e) {
        } finally {
            if (fo != null) {
                try {
                    fo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (xwpfDocument != null) {
                try {
                    xwpfDocument.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        FileEntity fileEntity = entityFactory.getFileEntity("Ready", filePath, fileName, "docx");
        fileEntity.setId(fileId);
        fileService.save(fileEntity);
    }

    @Async
    public void generateCountryExcelReport(List<LeagueEntity> leagueEntities, List<TeamEntity> teamEntities, int fileId, String realPathToUploads){

        Workbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = (HSSFSheet) workbook.createSheet("Country report");
        int rowNum = 0;
        String countryName = leagueEntities.get(0).getCountryByIdCountry().getName();
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

            String fileName = countryName + "CountryReport.xls";

            if(! new File(realPathToUploads).exists())
            {
                new File(realPathToUploads).mkdir();
            }

            String filePath = realPathToUploads + fileName;
            File dest = new File(filePath);

            FileOutputStream fo = null;
            try {
                fo = new FileOutputStream(dest);
                workbook.write(fo);
            } catch (IOException e) {
            } finally {
                if (fo != null) {
                    try {
                        fo.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (workbook != null) {
                    try {
                        workbook.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            FileEntity fileEntity = entityFactory.getFileEntity("Ready", filePath, fileName, "xls");
            fileEntity.setId(fileId);
            fileService.save(fileEntity);
        }
    }

    @Async
    public void generateLeagueExcelReport(List<TeamEntity> teamEntities, List<PlayerEntity> playerEntities, int fileId, String realPathToUploads){

        Workbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = (HSSFSheet) workbook.createSheet("League report");
        String leagueName = teamEntities.get(0).getLeagueByIdLeague().getName();
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

            String fileName = leagueName + "LeagueReport.xls";

            if(! new File(realPathToUploads).exists())
            {
                new File(realPathToUploads).mkdir();
            }

            String filePath = realPathToUploads + fileName;
            File dest = new File(filePath);

            FileOutputStream fo = null;
            try {
                fo = new FileOutputStream(dest);
                workbook.write(fo);
            } catch (IOException e) {
            } finally {
                if (fo != null) {
                    try {
                        fo.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (workbook != null) {
                    try {
                        workbook.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            FileEntity fileEntity = entityFactory.getFileEntity("Ready", filePath, fileName, "xls");
            fileEntity.setId(fileId);
            fileService.save(fileEntity);
        }
    }

    @Async
    public void generateTeamExcelReport(TeamEntity teamEntity, List<PlayerEntity> playerEntities, int fileId, String realPathToUploads){

        Workbook workbook = new HSSFWorkbook();
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
        for (PlayerEntity playerEntity : playerEntities) {
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

        String fileName = teamEntity.getName() + "TeamRoster.xls";

        if(! new File(realPathToUploads).exists())
        {
            new File(realPathToUploads).mkdir();
        }

        String filePath = realPathToUploads + fileName;
        File dest = new File(filePath);

        FileOutputStream fo = null;
        try {
            fo = new FileOutputStream(dest);
            workbook.write(fo);
        } catch (IOException e) {
        } finally {
            if (fo != null) {
                try {
                    fo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (workbook != null) {
                try {
                    workbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        FileEntity fileEntity = entityFactory.getFileEntity("Ready", filePath, fileName, "xls");
        fileEntity.setId(fileId);
        fileService.save(fileEntity);
    }
}
