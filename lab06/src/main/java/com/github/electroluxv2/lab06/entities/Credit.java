package com.github.electroluxv2.lab06.entities;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

@Entity
@Table(name = "credits")
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Public.class)
    private long id;
    @JsonView(Views.Public.class)
    private double amount;
    @JsonView(Views.Public.class)
    private long installmentCount;
    @JsonView(Views.Public.class)
    private InstallmentType installmentType;
    @JsonView(Views.Public.class)
    private double percentage;
    @JsonView(Views.Public.class)
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
