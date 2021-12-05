package com.example.demo;

import com.example.demo.controllers.ChartMaker;
import com.example.demo.repositories.records.DatasetEntry;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class DemoApplicationTests {

	HttpServletResponse response = new MockHttpServletResponse();

	@Mock
	List<DatasetEntry> dataset;

	String title = "title";
	String exporter = "bar";

	@Test
	public void staticExportShouldCallCorrectExporter() throws IOException {
		ChartMaker mockChartMaker = Mockito.mock(ChartMaker.class);
		mockChartMaker.export(exporter, response, dataset, title);
		Mockito.verify(mockChartMaker.BAR.getExporter(), times(1)).export(dataset, title);
	}
}
