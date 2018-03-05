package com.spp.chekh.pmbackend.document.view;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.spp.chekh.pmbackend.entity.CoachEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class CoachReportPDFView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter pdfWriter, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        Map<String,Object> coachReportDataMap = (Map<String,Object>) model.get("coachReportData");
        CoachEntity coachEntity = (CoachEntity) coachReportDataMap.get("coach");

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
    }
}
