package com.example.demo.services;

import com.example.demo.charts.BarChart;
import com.example.demo.charts.IChart;
import com.example.demo.charts.LinearChart;
import com.example.demo.charts.PieChart;
import com.example.demo.model.Month;
import com.example.demo.model.Payment;
import com.example.demo.model.Rental;
import com.example.demo.repositories.RentalRepository;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class RentalService {
    public RentalRepository rs;

    @Autowired
    public RentalService(RentalRepository rentalRepository) {
        this.rs = rs;
    }

    public RentalService() {
    }

    public int getIncomeByMonth(String from, String to) {
        Timestamp timeFrom = Timestamp.valueOf(from + " 00:00:01");
        Timestamp timeTo = Timestamp.valueOf(to + " 23:59:59");
        return rs.findAll().stream()
                .map(Rental::getPaymentsByRentalId)
                .map(x -> x.stream().filter(p -> p.getPaymentDate().after(timeFrom) && p.getPaymentDate().before(timeTo)))
                .map(x -> x.map(Payment::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add).intValue())
                .reduce(0, Integer::sum);
    }

    public List<Month> getIncomeByYear(int year) {
        ArrayList<Month> monthStats = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        IntStream.rangeClosed(1, 12).forEach(i -> temp.add(getIncomeByMonth(year + "-" + i + "-01", year + "-" + i + "-31")));
        IntStream.rangeClosed(1, 12).forEach(i -> monthStats.add(new Month(String.valueOf(i), (temp.get(i - 1)))));
        return monthStats;
    }

    public Object gerIncomeFromTo(String from, String to) {
        ArrayList<Month> monthStats = new ArrayList<>();
        LocalDate date = LocalDate.parse(from);
        LocalDate temp;
        while (date.isBefore(LocalDate.parse(to))) {
            temp = date;
            date = date.plusMonths(1);
            System.out.println(temp);
            monthStats.add(new Month(date.toString(), (getIncomeByMonth(temp.toString(), date.toString()))));
        }
        return monthStats;
    }

    public byte[] generateRentalLinearChart(String title, String xAxis, String yAxis, List<Month> entryData) throws IOException {
        LinearChart linearChartGenerator = new LinearChart();
        DefaultCategoryDataset dataset = (DefaultCategoryDataset) linearChartGenerator.getDataset();

        entryData.forEach(rentalStats -> dataset.setValue(
                (Number) rentalStats.getValue(),
                "",
                rentalStats.getMonth()
        ));

        return linearChartGenerator.generate(title, "linear", xAxis, yAxis);
    }

    public byte[] generateRentalBarChart(String title, String xAxis, String yAxis, List<Month> entryData) throws IOException {
        BarChart barChartGenerator = new BarChart();
        DefaultCategoryDataset dataset = (DefaultCategoryDataset) barChartGenerator.getDataset();

        entryData.forEach(stats -> dataset.setValue(
                (Number) stats.getValue(),
                "income",
                stats.getMonth()
        ));

        return barChartGenerator.generate(title, "bar", xAxis, yAxis);
    }

    public byte[] generateRentalPieChart(String title, List<Month> entryData) throws IOException {
        IChart pieChartGenerator = new PieChart();
        DefaultPieDataset dataset = (DefaultPieDataset) pieChartGenerator.getDataset();

        entryData.forEach(stats -> dataset.setValue(
                stats.getMonth(),
                (Number) stats.getValue())
        );

        return pieChartGenerator.generate(title, "pie", "", "");
    }
}