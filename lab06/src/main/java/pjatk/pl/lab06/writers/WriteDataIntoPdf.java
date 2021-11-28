package pjatk.pl.lab06.writers;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.PDType3Font;
import org.springframework.stereotype.Component;
import pjatk.pl.lab06.Loan.Installment;
import pjatk.pl.lab06.Loan.TimeTable;
import pjatk.pl.lab06.Services.TimeTableService;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class WriteDataIntoPdf {

    public static void writeDataIntoPdfMethod(int id, TimeTableService timeTableService) throws IOException{
        PDDocument pdDocument = new PDDocument();
        PDPage pdPage = new PDPage();
        pdDocument.addPage(pdPage);

        PDPageContentStream pdPageContentStream = new PDPageContentStream(pdDocument,pdPage);
        pdPageContentStream.beginText();
        pdPageContentStream.newLineAtOffset(50,600);
        pdPageContentStream.setFont(PDType1Font.COURIER,7);
        pdPageContentStream.setLeading(14);

        List<Installment> installmentList = timeTableService.getTimetable(id).getInstallments();

        for (Installment installment: installmentList){
            pdPageContentStream.showText(String.valueOf(installment.toString()));
            pdPageContentStream.newLine();
        }
        pdPageContentStream.endText();
        pdPageContentStream.close();
        pdDocument.save("/src/main/resources/installmentPDF.pdf");
        pdDocument.close();

    }


}
