package com.github.electroluxv2.lab06.entities;

import java.util.ArrayList;
import java.util.List;

public enum InstallmentType {
    DECREASING(credit -> {
        final var installments = new ArrayList<Installment>();

        final var amount = credit.getAmount();
        final var percentage = credit.getPercentage();
        final var count = credit.getInstallmentCount();
        final var fixedRate = credit.getFixedRate();

        final var constCapitalRate = amount / (count * count);
        final var toPayTotal = (constCapitalRate * count) + (fixedRate * count) + (percentage * amount);

        double lastInterestRate = 0;
        double totalPayed = 0;
        for (var number = 1; number <= count; number++) {
            final var currentInterestRate = ((amount - lastInterestRate) * percentage) / count;
            final var totalRate = constCapitalRate + currentInterestRate + fixedRate;

            totalPayed += totalRate;
            lastInterestRate = currentInterestRate;

            final var toPayLeft = toPayTotal - totalPayed;

            installments.add(new Installment(credit.getId(), number, totalPayed, currentInterestRate, fixedRate, toPayLeft, totalRate));
        }

        return installments;
    }),
    CONSTANT(credit -> {
        final var installments = new ArrayList<Installment>();

        final var amount = credit.getAmount();
        final var percentage = credit.getPercentage();
        final var count = credit.getInstallmentCount();
        final var fixedRate = credit.getFixedRate();

        final var constRate = amount / count;
        final var constInterest = (amount * percentage) / count;

        final var capitalTotal = (constRate * count) + (constInterest * count) + (fixedRate * count);

        var capitalPayed = 0;

        for (var number = 1; number <= count; number++) {
            final var currentRateTotal = constRate + constInterest + fixedRate;
            capitalPayed += currentRateTotal;
            final var capitalLeft = capitalTotal - capitalPayed;

            installments.add(new Installment(credit.getId(), number, capitalPayed, constInterest, fixedRate, capitalLeft, currentRateTotal));
        }

        return installments;
    });

    private final Formula formula;

    InstallmentType(final Formula formula) {
        this.formula = formula;
    }

    public List<Installment> calculateInstalments(final Credit credit) {
        return formula.calculateInstalments(credit);
    }
}
