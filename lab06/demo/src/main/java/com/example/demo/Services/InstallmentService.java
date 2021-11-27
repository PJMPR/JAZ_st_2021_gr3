package com.example.demo.Services;

import com.example.demo.Repositories.InstallmentRepository;
import com.example.demo.Timetable.Installment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InstallmentService {
    InstallmentRepository installmentRepository;

    @Autowired
    public InstallmentService(InstallmentRepository installmentRepository) {
        this.installmentRepository = installmentRepository;
    }

    public void saveInstallments(Installment installment) {
        installmentRepository.save(installment);
    }
}
