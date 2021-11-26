package com.github.electroluxv2.lab06;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.electroluxv2.lab06.entities.Credit;
import com.github.electroluxv2.lab06.entities.Installment;
import com.github.electroluxv2.lab06.entities.InstallmentType;
import com.github.electroluxv2.lab06.repositories.CreditRepository;
import com.github.electroluxv2.lab06.repositories.InstallmentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class BankIntegrationTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private CreditRepository creditRepository;

    @Autowired
    private InstallmentRepository installmentRepository;
    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void creditCalculationsShouldReturnCorrectCreditId() throws Exception {
        final var credit = new Credit(10000, 12, InstallmentType.CONSTANT, 0.10, 5);

        final var result = mvc.perform(post("/credit/calculations")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(credit)))
                .andExpect(status().isCreated())
                .andReturn();

        final var returnedId = Long.parseLong(result.getResponse().getContentAsString());
        assertNotEquals(0, returnedId, "Returned id should not be 0");

        // I don't know ho to get next generated id for H2
        // assertEquals(nextId, returnedId, "Credit id and id from response should match");
    }

    @Test
    public void creditCalculationsShouldCreateCorrectAmountOfInstalments() throws Exception {
        final var credit = new Credit(10000, 12, InstallmentType.DECREASING, 0.10, 5);

        final var result = mvc.perform(post("/credit/calculations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(credit)))
                .andExpect(status().isCreated())
                .andReturn();

        final var returnedId = result.getResponse().getContentAsString();

        final var instalmentsRaw = mvc.perform(get("/credit/timetable/%s".formatted(returnedId))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        final var json = instalmentsRaw.getResponse().getContentAsString();

        final var installments = Arrays.asList(mapper.readValue(json, Installment[].class));
        final var validNumbers = LongStream.rangeClosed(1, credit.getInstallmentCount()).boxed().toList();

        final var correctInstallmentsCount = (long) installments.stream()
                .filter(installment -> validNumbers.contains(installment.getNumber()))
                .toList()
                .size();

        assertEquals(credit.getInstallmentCount(), correctInstallmentsCount, "Credit calculations should create correct amount of installments");
    }
}
