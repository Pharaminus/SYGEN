package com.APP.SYGEN.service;

import com.lowagie.text.DocumentException;

import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Component;
import org.xhtmlrenderer.pdf.ITextRenderer;

@Component
public class PdfGenerator {

    public void generatePdf(String htmlContent, String outputFilePath) throws DocumentException, IOException {
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(htmlContent);
        renderer.layout();
        renderer.createPDF(new FileOutputStream(outputFilePath));
        renderer.finishPDF();
    }
}

