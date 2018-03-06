package com.spp.chekh.pmbackend.service.impl.document;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfCopy;
import com.lowagie.text.pdf.PdfReader;
import com.spp.chekh.pmbackend.entity.FileEntity;
import com.spp.chekh.pmbackend.service.interfaces.document.DocumentDownloadService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;


@Service
public class DocumentDownloadServiceImpl implements DocumentDownloadService {

    public void downloadExcelDocument(FileEntity fileEntity, HttpServletResponse httpServletResponse) throws Exception {
        File file = new File(fileEntity.getPath());
        FileInputStream fis = new FileInputStream(file);
        Workbook workbook = new HSSFWorkbook(fis);

        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        workbook.write(servletOutputStream);

        httpServletResponse.setContentType("application/vnd.ms-excel");
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=" + fileEntity.getName());
    }

    public void downloadWordDocument(FileEntity fileEntity, HttpServletResponse httpServletResponse) throws Exception{
        File file = new File(fileEntity.getPath());
        FileInputStream fis = new FileInputStream(file);
        XWPFDocument xwpfDocument = new XWPFDocument(fis);

        httpServletResponse.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=" + fileEntity.getName());

        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        xwpfDocument.write(servletOutputStream);
    }

    public void downloadPdfDocument(FileEntity fileEntity, HttpServletResponse httpServletResponse) throws Exception{

        httpServletResponse.setContentType("application/pdf");
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=" + fileEntity.getName());
        PdfReader reader = new PdfReader(fileEntity.getPath());
        int n = reader.getNumberOfPages();
        Document document = new Document();
        PdfCopy copy = new PdfCopy(document, httpServletResponse.getOutputStream());
        document.open();
        for (int i = 0; i < n;) {
            copy.addPage(copy.getImportedPage(reader, ++i));
        }
        document.close();
    }
}
