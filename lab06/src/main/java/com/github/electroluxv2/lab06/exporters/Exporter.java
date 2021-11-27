package com.github.electroluxv2.lab06.exporters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.electroluxv2.lab06.entities.Installment;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.json.CDL;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public interface Exporter {
    byte[] export(final List<Installment> installments) throws Exception;

    Exporter JSON = installments -> new ObjectMapper().writeValueAsBytes(installments);

    Exporter CSV = installments -> CDL.toString(new JSONObject("{\"i\":%s}".formatted(new String(JSON.export(installments)))).getJSONArray("i")).getBytes();

    Exporter PDF = installments -> {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter.getInstance(document, stream);

        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);

        PdfPTable table = new PdfPTable(6);

        Stream.of(("number,capital,amount,capitalToPay,interest,fixedFee").split(","))
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setBorderWidth(2);
                    header.setPhrase(new Phrase(columnTitle));
                    table.addCell(header);
                });

        installments.stream()
                .map(Installment::toString)
                .map(s -> s.split("\n"))
                .flatMap(Arrays::stream)
                .forEach(table::addCell);

        document.add(table);
        document.close();

        return stream.toByteArray();
    };

    Map<String, Exporter> exporters = Map.of("json", JSON, "csv", CSV, "pdf", PDF);
}
