package com.github.electroluxv2.lab06.service;

import com.github.electroluxv2.lab06.entity.Credit;
import com.github.electroluxv2.lab06.entity.Installment;
import com.github.electroluxv2.lab06.entity.InstallmentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CreditService {
    final CreditRepository creditRepository;
    final InstallmentRepository installmentRepository;

    @Autowired
    public CreditService(final CreditRepository creditRepository, final InstallmentRepository installmentRepository) {
        this.creditRepository = creditRepository;
        this.installmentRepository = installmentRepository;
    }

    public long add() {
        var creditId = creditRepository.save(new Credit(2000, 10, InstallmentType.DECREASING, 12, 20)).getId();

        var installments = new ArrayList<Installment>();

        for (var i = 1; i <= 10; i++) {
            installments.add(new Installment(creditId, i, i * 10, creditId * 100, creditId * 10, (creditId * 1000) - (i * 100), i * 120));
        }

        installmentRepository.saveAll(installments);

        return creditId;
    }
}
