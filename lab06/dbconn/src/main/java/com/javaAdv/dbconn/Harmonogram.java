package com.javaAdv.dbconn;

import javax.persistence.*;

@Entity
@Table(name = "harmonogram")
public class Harmonogram {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private Integer num;
    @Column
    private Float capital;
    @Column
    private Float interest;
    @Column
    private Integer fixed_rate;
    @Column
    private Float capitalToPay;
    @Column
    private Float amount;
    public Harmonogram(){

    }
    public Harmonogram(Integer id, Integer num, Float capital, Float interest, Integer fixed_rate, Float capitalToPay, Float amount) {
        this.id = id;
        this.num = num;
        this.capital = capital;
        this.interest = interest;
        this.fixed_rate = fixed_rate;
        this.capitalToPay = capitalToPay;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Float getCapital() {
        return capital;
    }

    public void setCapital(Float capital) {
        this.capital = capital;
    }

    public Float getInterest() {
        return interest;
    }

    public void setInterest(Float interest) {
        this.interest = interest;
    }

    public Integer getFixed_rate() {
        return fixed_rate;
    }

    public void setFixed_rate(Integer fixed_rate) {
        this.fixed_rate = fixed_rate;
    }

    public Float getCapitalToPay() {
        return capitalToPay;
    }

    public void setCapitalToPay(Float capitalToPay) {
        this.capitalToPay = capitalToPay;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }
}
