package com.example.demo;

import com.example.demo.Calculator.Calculator;
import com.example.demo.Timetable.Installment;
import com.example.demo.Timetable.InstallmentType;
import com.example.demo.Timetable.Timetable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    Calculator calculator = new Calculator();

    @Test
    public void testShouldPassIfInstallmentsHave36elements() {
        Timetable timetable = new Timetable(1, 1000, 36, InstallmentType.decreasing, 0.07, 30);
        List<Installment> installments = calculator.calculate(timetable);
        Assertions.assertEquals(installments.size(), 36);
    }

    @Test
    public void testShouldPassIfInstallmentsAreEmpty() {
        Timetable timetable = new Timetable(1, 1000, 0, InstallmentType.decreasing, 0.07, 30);
        List<Installment> installments = calculator.calculate(timetable);
        Assertions.assertTrue(installments.isEmpty());
    }

    @Test
    public void testShouldPassIfTimetableInstallmentTypeIsConstant() {
        Timetable timetable = new Timetable(1, 2000, 20, InstallmentType.constant, 0.1, 25);
        Assertions.assertEquals(timetable.getInstallmentType(), InstallmentType.constant);
    }
}
