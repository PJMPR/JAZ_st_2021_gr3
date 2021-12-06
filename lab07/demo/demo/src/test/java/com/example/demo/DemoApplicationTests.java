package com.example.demo;

import com.example.demo.controllers.ChartMaker;
import com.example.demo.repositories.records.DatasetEntry;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class DemoApplicationTests {

	HttpServletResponse response = new MockHttpServletResponse();
	List<DatasetEntry> dataset = new ArrayList<>(List.of(new DatasetEntry("key", 12)));

	String title = "title";
	String exporter = "bar";

	@Test
	public void staticExportShouldCallCorrectExporter() throws IOException {
		ChartMaker mockChartMaker = Mockito.mock(ChartMaker.class);
		mockChartMaker.export(exporter, response, dataset, title);
		Mockito.verify(mockChartMaker.BAR.getExporter(), times(1)).export(dataset, title);
	}

	@Test
	public void allExportersShouldWork() {
		for (var exporter : ChartMaker.values()) {
			assertDoesNotThrow(() -> ChartMaker.export(exporter.name(), response, dataset, title));
		}
	}
}
