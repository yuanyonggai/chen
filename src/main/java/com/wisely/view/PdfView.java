package com.wisely.view;

import java.awt.Color;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.wisely.domain.DemoObj;

public class PdfView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model,
            Document document, PdfWriter writer, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        DemoObj demoObj = (DemoObj) model.get("demoObj");

        PdfPTable table = new PdfPTable(2);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.getDefaultCell().setBackgroundColor(Color.lightGray);

        table.addCell("ID");
        table.addCell("NAME");

        table.addCell(demoObj.getId().toString());
        table.addCell(demoObj.getName());

        document.add(table);
    }

}