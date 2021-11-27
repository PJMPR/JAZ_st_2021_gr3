package pl.pjwstk.lab06.accestodatabase.Timetable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Installment {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private int credit_id;
    private int number;
    private double capital;
    private double interest;
    private double fixedFee;
    private double capitalToPay;
    private double amount;

    public Installment(double capital, double interest, double fixedFee, double capitalToPay, double amount, int creditnumber) {
        this.capital = capital;
        this.interest = interest;
        this.fixedFee = fixedFee;
        this.capitalToPay = capitalToPay;
        this.amount = amount;
        this.credit_id = creditnumber;
    }

    public int getCredit_id() {
        return credit_id;
    }

    public void setCredit_id(int credit_id) {
        this.credit_id = credit_id;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getFixedFee() {
        return fixedFee;
    }

    public void setFixedFee(double fixedFee) {
        this.fixedFee = fixedFee;
    }

    public double getCapitalToPay() {
        return capitalToPay;
    }

    public void setCapitalToPay(double capitalToPay) {
        this.capitalToPay = capitalToPay;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


}
