package com.example.lab06.schedules;

import com.example.lab06.parameters.Credit;
import com.example.lab06.parameters.TimeTable;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;
import java.util.List;

public class WriteDataIntoPDF implements Exporter{

    public void pdfExport(Credit credit, TimeTable timeTable) throws IOException, IllegalAccessException {
        PDDocument pdDocument = new PDDocument();
        PDPage pdPage = new PDPage();
        pdDocument.addPage(pdPage);
        PDPageContentStream pageContentStream = new PDPageContentStream(pdDocument, pdPage);

        pageContentStream.beginText();
        pageContentStream.newLineAtOffset(50, 700);
        pageContentStream.setFont(PDType1Font.HELVETICA, 5);
        pageContentStream.setLeading(14.5f);

        List<String[]> records = create(credit, timeTable);
        int i = 0;
        for (String part : records.get(0)){
            pageContentStream.showText(part + ":");
            pageContentStream.showText(records.get(1)[i]);
            i++;
            pageContentStream.newLine();
        }

        pageContentStream.endText();
        pageContentStream.close();
        pdDocument.save("src/Credit.pdf");
        pdDocument.close();
    }
}