package com.spp.chekh.pmfrontend.controller;

import com.spp.chekh.pmbackend.entity.*;
import com.spp.chekh.pmbackend.factory.EntityFactory;
import com.spp.chekh.pmbackend.service.interfaces.*;
import com.spp.chekh.pmbackend.service.interfaces.document.DocumentDownloadService;
import com.spp.chekh.pmbackend.service.interfaces.document.DocumentGeneratorService;
import com.spp.chekh.pmfrontend.exception.ResourceNotFoundException;
import com.spp.chekh.pmfrontend.view.model.custom.DocumentStatusViewModel;
import com.spp.chekh.pmfrontend.view.model.factory.ViewModelFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@Controller
public class DocumentController {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private LeagueService leagueService;

    @Autowired
    private CoachService coachService;

    @Autowired
    private DocumentGeneratorService documentGenerator;

    @Autowired
    private EntityFactory entityFactory;

    @Autowired
    private FileService fileService;

    @Autowired
    private DocumentDownloadService documentDownloadService;

    @Autowired
    private ViewModelFactory viewModelFactory;

    @RequestMapping(value = "/document/team/{id}/report", method = RequestMethod.GET)
    @ResponseBody
    public DocumentStatusViewModel generateTeamRosterExcelDocument(@PathVariable int id, HttpServletRequest request){
        List<PlayerEntity> playerEntities = playerService.findByIdTeam(id);
        TeamEntity teamEntity = teamService.findById(id);

        if(teamEntity == null){
            throw new ResourceNotFoundException();
        }

        String realPathToUploads = getRealPathToUploadsFolder(request);

        FileEntity fileEntity = entityFactory.getFileEntity("Creating", "", "", "xls");
        fileService.save(fileEntity);
        int fileId = fileService.findFirstByOrderByIdDesc().getId();

        documentGenerator.generateTeamExcelReport(teamEntity, playerEntities, fileId, realPathToUploads);

        return viewModelFactory.getDocumentViewModel(fileId, "Creating");
    }

    @RequestMapping(value = "/document/league/{id}/report", method = RequestMethod.GET)
    @ResponseBody
    public DocumentStatusViewModel generateLeagueExcelDocument(@PathVariable int id, HttpServletRequest request){
        List<PlayerEntity> playerEntities = playerService.findAllByLeagueId(id);
        List<TeamEntity> teamEntities = teamService.findByIdLeague(id);

        if(teamEntities == null || playerEntities == null){
            throw new ResourceNotFoundException();
        }

        String realPathToUploads = getRealPathToUploadsFolder(request);

        FileEntity fileEntity = entityFactory.getFileEntity("Creating", "", "", "xls");
        fileService.save(fileEntity);
        int fileId = fileService.findFirstByOrderByIdDesc().getId();

        documentGenerator.generateLeagueExcelReport(teamEntities, playerEntities, fileId, realPathToUploads);

        return viewModelFactory.getDocumentViewModel(fileId, "Creating");
    }

    @RequestMapping(value = "/document/country/{id}/report", method = RequestMethod.GET)
    @ResponseBody
    public DocumentStatusViewModel generateCountryExcelDocument(@PathVariable int id, HttpServletRequest request){
        List<TeamEntity> teamEntities = teamService.findAllByCountryId(id);
        List<LeagueEntity> leagueEntities = leagueService.findByIdCountry(id);

        if(teamEntities == null || leagueEntities == null){
            throw new ResourceNotFoundException();
        }

        String realPathToUploads = getRealPathToUploadsFolder(request);

        FileEntity fileEntity = entityFactory.getFileEntity("Creating", "", "", "xls");
        fileService.save(fileEntity);
        int fileId = fileService.findFirstByOrderByIdDesc().getId();

        documentGenerator.generateCountryExcelReport(leagueEntities, teamEntities, fileId, realPathToUploads);

        return viewModelFactory.getDocumentViewModel(fileId, "Creating");
    }

    @RequestMapping(value = "/document/player/{id}/report", method = RequestMethod.GET)
    @ResponseBody
    public DocumentStatusViewModel generatePlayerWordDocument(@PathVariable int id, HttpServletRequest request){
        PlayerEntity playerEntity = playerService.findById(id);

        if(playerEntity == null){
            throw new ResourceNotFoundException();
        }

        String realPathToUploads = getRealPathToUploadsFolder(request);

        FileEntity fileEntity = entityFactory.getFileEntity("Creating", "", "", "docx");
        fileService.save(fileEntity);
        int fileId = fileService.findFirstByOrderByIdDesc().getId();

        documentGenerator.generatePlayerWordReport(playerEntity, fileId, realPathToUploads);

        return viewModelFactory.getDocumentViewModel(fileId, "Creating");
    }

    @RequestMapping(value = "/document/coach/{id}/report", method = RequestMethod.GET)
    @ResponseBody
    public DocumentStatusViewModel generatePdfFile(@PathVariable int id, HttpServletRequest request) throws Exception {
        CoachEntity coachEntity = coachService.findById(id);

        if(coachEntity == null){
            throw new ResourceNotFoundException();
        }

        String realPathToUploads = getRealPathToUploadsFolder(request);

        FileEntity fileEntity = entityFactory.getFileEntity("Creating", "", "", "pdf");
        fileService.save(fileEntity);
        int fileId = fileService.findFirstByOrderByIdDesc().getId();

        documentGenerator.generateCoachPDFReport(coachEntity, fileId, realPathToUploads);

        return viewModelFactory.getDocumentViewModel(fileId, "Creating");
    }

    @RequestMapping(value = "/document/{id}/check", method = RequestMethod.GET)
    @ResponseBody
    public DocumentStatusViewModel checkDocument(@PathVariable int id) throws FileNotFoundException {
        FileEntity fileEntity = fileService.findById(id);
        if(fileEntity == null){
            throw new FileNotFoundException();
        }
        return viewModelFactory.getDocumentViewModel(id, fileEntity.getStatus());
    }

    @RequestMapping(value = "/document/{id}/download", method = RequestMethod.GET)
    public void downloadFile(@PathVariable int id, HttpServletRequest request, HttpServletResponse httpServletResponse) throws Exception {
        FileEntity fileEntity = fileService.findById(id);
        if(fileEntity == null){
            throw new FileNotFoundException();
        }

        switch (fileEntity.getType()){
            case "xls": {
                documentDownloadService.downloadExcelDocument(fileEntity, httpServletResponse);
                break;
            }
            case "docx": {
                documentDownloadService.downloadWordDocument(fileEntity, httpServletResponse);
                break;
            }
            case "pdf": {
                documentDownloadService.downloadPdfDocument(fileEntity, httpServletResponse);
                break;
            }
        }
    }

    private String getRealPathToUploadsFolder(HttpServletRequest request){
        String uploadsDir = "/uploads/";
        String realPathToUploads =  request.getServletContext().getRealPath(uploadsDir);
        return realPathToUploads;
    }

}
