package com.spp.chekh.pmbackend.service.interfaces.document;

import com.spp.chekh.pmbackend.entity.*;
import javax.servlet.http.HttpServletResponse;

public interface DocumentDownloadService {
    void downloadExcelDocument(FileEntity fileEntity, HttpServletResponse httpServletResponse) throws Exception;
    void downloadWordDocument(FileEntity fileEntity, HttpServletResponse httpServletResponse) throws Exception;
    void downloadPdfDocument(FileEntity fileEntity, HttpServletResponse httpServletResponse) throws Exception;
}