package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class Lab06ApplicationTests {

	@MockBean
	ScheduleRowRepository scheduleRowRepository;
	@Test
	void contextLoads() {
	}

	@Test
	void howDoITestThis(){
		LoanRepaymentSchedule loanRepaymentSchedule = new LoanRepaymentSchedule(10000, 12, InstallmentTypes.FIXED, 5, 0);
		Calculator calculator = new Calculator();
		var wynik = calculator.calculate(loanRepaymentSchedule);
		scheduleRowRepository.saveAll(wynik);
		System.out.println(scheduleRowRepository.findAll());
		assertEquals(12,scheduleRowRepository.count() );
	}

}
