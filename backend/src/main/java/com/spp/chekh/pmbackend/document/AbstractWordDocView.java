package com.spp.chekh.pmbackend.document;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Closeable;
import java.io.IOException;
import java.util.Map;

public abstract class AbstractWordDocView extends AbstractView {

    public AbstractWordDocView() {
        this.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
    }

    protected boolean generatesDownloadContent() {
        return true;
    }

    @Override
    protected final void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        XWPFDocument xwpfDocument = this.createDocument(model, httpServletRequest);
        this.buildWordDocument(model, xwpfDocument, httpServletRequest, httpServletResponse);
        httpServletResponse.setContentType(this.getContentType());
        this.renderDocument(xwpfDocument, httpServletResponse);
    }

    protected XWPFDocument createDocument(Map<String, Object> model, HttpServletRequest request) {
        return new XWPFDocument();
    }

    protected void renderDocument(XWPFDocument xwpfDocument, HttpServletResponse response) throws IOException {
        ServletOutputStream servletOutputStream = response.getOutputStream();
        xwpfDocument.write(servletOutputStream);
        if (xwpfDocument instanceof Closeable) {
            xwpfDocument.close();
        }
    }

    protected abstract void buildWordDocument(Map<String, Object> model,  XWPFDocument xwpfDocument, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception;
}
