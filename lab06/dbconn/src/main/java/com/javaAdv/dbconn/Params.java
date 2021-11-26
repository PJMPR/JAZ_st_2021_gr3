package com.javaAdv.dbconn;

import javax.persistence.*;

@Entity
@Table(name = "params")
public class Params {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private Float amount;
    @Column
    private Float installment_count;
    @Column
    private String installment_type;
    @Column
    private Float percentage;
    @Column
    private Integer fixedRate;

    public Float getInstallment_count() {
        return installment_count;
    }

    public void setInstallment_count(Float installment_count) {
        this.installment_count = installment_count;
    }

    public String getInstallment_type() {
        return installment_type;
    }

    public void setInstallment_type(String installment_type) {
        this.installment_type = installment_type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Float getPercentage() {
        return percentage;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }

    public Integer getFixedRate() {
        return fixedRate;
    }

    public void setFixedRate(Integer fixedRate) {
        this.fixedRate = fixedRate;
    }
}
