package com.spp.chekh.pmbackend.document.view;

import com.spp.chekh.pmbackend.document.AbstractWordDocView;
import com.spp.chekh.pmbackend.entity.PlayerEntity;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class PlayerReportWordDocView extends AbstractWordDocView {

    @Override
    protected void buildWordDocument(Map<String, Object> model, XWPFDocument xwpfDocument, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        Map<String,Object> playerReportDataMap = (Map<String,Object>) model.get("playerReportData");
        PlayerEntity playerEntity = (PlayerEntity) playerReportDataMap.get("player");

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

        httpServletResponse.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        String fileName = playerEntity.getSurname() + " report.docx";
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=" + fileName);
    }
}
