package jaz.lab06.demo.credit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Credit {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int id;

    public int Amount;

    public int installmentCount;

    public String installmentType;

    public float percentage;

    public float fixedRate;

    public int number;

    public float capital;

    public float interest;

    public float fixedFee;

    public float capitalToPay;

    public int singleInstallmentAmount;

    //Absolutely not correct and unnecessary credit count (I am not economist)
    public void count(){
        interest = this.getAmount() * this.getPercentage();
        singleInstallmentAmount = (int) (this.getAmount()/ this.getInstallmentCount() + interest);
        capital = number * singleInstallmentAmount;
        capitalToPay = this.getAmount() - capital;
        fixedFee = this.getFixedRate();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public int getInstallmentCount() {
        return installmentCount;
    }

    public void setInstallmentCount(int installmentCount) {
        this.installmentCount = installmentCount;
    }

    public String getInstallmentType() {
        return installmentType;
    }

    public void setInstallmentType(String installmentType) {
        this.installmentType = installmentType;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public float getFixedRate() {
        return fixedRate;
    }

    public void setFixedRate(float fixedRate) {
        this.fixedRate = fixedRate;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public float getCapital() {
        return capital;
    }

    public void setCapital(float capital) {
        this.capital = capital;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public float getFixedFee() {
        return fixedFee;
    }

    public void setFixedFee(float fixedFee) {
        this.fixedFee = fixedFee;
    }

    public float getCapitalToPay() {
        return capitalToPay;
    }

    public void setCapitalToPay(float capitalToPay) {
        this.capitalToPay = capitalToPay;
    }

    public int getSingleInstallmentAmount() {
        return singleInstallmentAmount;
    }

    public void setSingleInstallmentAmount(int SingleInstallmentAmount) {
        this.singleInstallmentAmount = SingleInstallmentAmount;
    }
}