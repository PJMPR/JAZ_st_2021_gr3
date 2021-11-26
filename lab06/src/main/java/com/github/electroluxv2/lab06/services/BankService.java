package com.github.electroluxv2.lab06.services;

import com.github.electroluxv2.lab06.entities.Credit;
import com.github.electroluxv2.lab06.entities.Installment;
import com.github.electroluxv2.lab06.repositories.CreditRepository;
import com.github.electroluxv2.lab06.repositories.InstallmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BankService {
    final CreditRepository creditRepository;
    final InstallmentRepository installmentRepository;

    @Autowired
    public BankService(final CreditRepository creditRepository, final InstallmentRepository installmentRepository) {
        this.creditRepository = creditRepository;
        this.installmentRepository = installmentRepository;
    }

    public long calculateCredit(final Credit credit) {
        var creditId = creditRepository.save(credit).getId();

        var installments = credit.getInstallmentType().calculateInstalments(credit);
        installmentRepository.saveAll(installments);

        return creditId;
    }

    public List<Installment> getInstallmentsByCreditId(final long creditId) {
        return installmentRepository.findAllByCreditId(creditId);
    }
}
