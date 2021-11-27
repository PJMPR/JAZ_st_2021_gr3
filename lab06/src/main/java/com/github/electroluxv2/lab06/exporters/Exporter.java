package com.github.electroluxv2.lab06.exporters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.electroluxv2.lab06.entities.Installment;
import com.github.electroluxv2.lab06.things.that.should.not.exist.but.java.needs.them.tldr.trash.Views;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.json.CDL;
import org.json.JSONObject;
import org.springframework.http.MediaType;

import java.io.ByteArrayOutputStream;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public interface Exporter {
    byte[] export(final List<Installment> installments) throws Exception;

    Exporter JSON = installments -> new ObjectMapper().writerWithView(Views.Public.class).writeValueAsBytes(installments);

    Exporter CSV = installments -> CDL.toString(new JSONObject("{\"i\":%s}".formatted(new String(JSON.export(installments)))).getJSONArray("i")).getBytes();

    Exporter PDF = installments -> {
        final var stream = new ByteArrayOutputStream();
        final var document = new Document(new Rectangle(PageSize.A4.getHeight(), PageSize.A4.getWidth(), 90), 10, 10, 10, 10);

        PdfWriter.getInstance(document, stream);
        document.open();

        final var table = new PdfPTable(6);

        Stream.of(("number,capital,interest,fixedFee,amount,capitalToPay")
                .split(","))
                .forEach(columnTitle -> {
                    final var header = new PdfPCell();
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

    Map<String, SimpleImmutableEntry<MediaType, Exporter>> exporters = Map.of(
            "json", new SimpleImmutableEntry<>(MediaType.APPLICATION_JSON, JSON),
            "csv", new SimpleImmutableEntry<>(MediaType.TEXT_PLAIN, CSV),
            "pdf", new SimpleImmutableEntry<>(MediaType.APPLICATION_PDF, PDF)
    );
}
