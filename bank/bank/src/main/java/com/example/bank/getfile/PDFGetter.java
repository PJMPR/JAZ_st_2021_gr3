/*package com.example.bank.getfile;

import java.util.Arrays;
import java.util.List;
import com.example.bank.model.Credit;
import com.example.bank.model.Timetable;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;

public class PDFGetter implements Getter {
    public void getFile(Credit credit, Timetable timetable) throws IOException, IllegalAccessException{
        try {
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < getData(credit,timetable).stream().count(); i++) {
                sb.append(getData(credit,timetable));
            }
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("src/main/PDF.pdf"));
            document.open();
            document.add();
            document.close();

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
