
package jaz.lab06.demo.exporters;

import Lab06.Credit.Credit;
import Lab06.FilesBuilders.Exporter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;
import java.util.List;

public class PDFExporter implements Exporter {

    public void createPDF(Credit creditData) throws IOException, IllegalAccessException {
        PDDocument pdf = new PDDocument();
        PDPage page = new PDPage();
        pdf.addPage(page);
        PDPageContentStream contents = new PDPageContentStream(pdf, page);

        contents.beginText();
        contents.newLineAtOffset(50, 700);
        contents.setFont(PDType1Font.HELVETICA, 5);
        contents.setLeading(14.5f);

        List<String[]> records = createSimpleData(creditData);
        int i = 0;
        for (String part: records.get(0)) {
            contents.showText(part + ":");
            contents.showText(records.get(1)[i]);
            i++;
            contents.newLine();
        }

        contents.endText();
        contents.close();
        pdf.save("src/main/resources/generatedPDF.pdf");
        pdf.close();
    }
}