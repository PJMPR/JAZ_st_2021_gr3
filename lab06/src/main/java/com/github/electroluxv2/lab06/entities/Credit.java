package com.github.electroluxv2.lab06.entities;

import javax.persistence.*;

@Entity
@Table(name = "credits")
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double amount;
    private long installmentCount;
    private InstallmentType installmentType;
    private double percentage;
    private double fixedRate;

    public Credit() { }

    public Credit(final double amount, final long installmentCount, final InstallmentType installmentType, final double percentage, final double fixedRate) {
        this.amount = amount;
        this.installmentCount = installmentCount;
        this.installmentType = installmentType;
        this.percentage = percentage;
        this.fixedRate = fixedRate;
    }

    public long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public long getInstallmentCount() {
        return installmentCount;
    }

    public InstallmentType getInstallmentType() {
        return installmentType;
    }

    public double getPercentage() {
        return percentage;
    }

    public double getFixedRate() {
        return fixedRate;
    }
}
