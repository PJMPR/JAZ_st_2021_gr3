package com.example.demo.Timetable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "timetable")
public class Timetable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private double amount;
    private int installmentCount;
    private InstallmentType installmentType;
    private double percentage;
    private double fixedFee;

    @OneToMany
    @JoinColumn(name = "timetable_id")
    private List<Installment> installments = new ArrayList<>();

    public Timetable() {
    }

    public Timetable(int id, double amount, int installmentCount, InstallmentType installmentType, double percentage, double fixedFee) {
        this.id = id;
        this.amount = amount;
        this.installmentCount = installmentCount;
        this.installmentType = installmentType;
        this.percentage = percentage;
        this.fixedFee = fixedFee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getInstallmentCount() {
        return installmentCount;
    }

    public void setInstallmentCount(int installmentCount) {
        this.installmentCount = installmentCount;
    }

    public InstallmentType getInstallmentType() {
        return installmentType;
    }

    public void setInstallmentType(InstallmentType installmentType) {
        this.installmentType = installmentType;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public double getFixedFee() {
        return fixedFee;
    }

    public void setFixedRate(double fixedRate) {
        this.fixedFee = fixedRate;
    }

    public List<Installment> getInstallments() {
        return installments;
    }

    public void setInstallments(List<Installment> installments) {
        this.installments = installments;
    }
}
