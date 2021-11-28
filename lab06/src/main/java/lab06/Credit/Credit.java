package Lab06.Credit;

import Lab06.Enum.InstalmentType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    protected float amount;                   // wnioskowana kwota kredytu
    protected Integer installmentCount;           // ilość rat
    protected InstalmentType instalmentType;  // rodzaj rat
    protected float percentage;               // oprocentowanie kredytu
    protected float fixedRate;                // opłaty stałeprotected
    protected int instalmentNumber;           // numer raty
    protected float capital;                  // czesc kapitalu splaconego
    protected float interest;                 // czesc odsetkowa
    protected float fixedFee;                 // oplata stala
    protected float capitalToPay;             //kapital pozostaly do splaty
    protected float finalinstamlentAmount;    // calkowita kwota raty

    public Credit() {
    }

    public Credit(float amount, Integer installmentCount, InstalmentType instalmentType, float percentage, float fixedRate) {
        this.amount = amount;
        this.installmentCount = installmentCount;
        this.instalmentType = instalmentType;
        this.percentage = percentage;
        this.fixedRate = fixedRate;
    }

    public void doTheMath() {
        interest = this.getAmount() * this.getPercentage();
        finalinstamlentAmount = (int) (this.getAmount()/ this.getInstallmentCount() + interest);
        capital = instalmentNumber * finalinstamlentAmount;
        capitalToPay = this.getAmount() - capital;
        fixedFee = this.getFixedRate();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getInstallmentCount() {
        return installmentCount;
    }

    public void setInstallmentCount(int installmentCOunt) {
        this.installmentCount = installmentCOunt;
    }

    public InstalmentType getInstalmentType() {
        return instalmentType;
    }

    public void setInstalmentType(InstalmentType instalmentType) {
        this.instalmentType = instalmentType;
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

    public int getInstalmentNumber() {
        return instalmentNumber;
    }

    public void setInstalmentNumber(int instalmentNumber) {
        this.instalmentNumber = instalmentNumber;
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

    public float getFinalinstamlentAmount() {
        return finalinstamlentAmount;
    }

    public void setFinalinstamlentAmount(float finalinstamlentAmount) {
        this.finalinstamlentAmount = finalinstamlentAmount;
    }

    @Override
    public String toString() {
        return "Credit{" +
                "id=" + id +
                ", amount=" + amount +
                ", installmentCount=" + installmentCount +
                ", instalmentType=" + instalmentType +
                ", percentage=" + percentage +
                ", fixedRate=" + fixedRate +
                ", instalmentNumber=" + instalmentNumber +
                ", capital=" + capital +
                ", interest=" + interest +
                ", fixedFee=" + fixedFee +
                ", capitalToPay=" + capitalToPay +
                ", finalinstamlentAmount=" + finalinstamlentAmount +
                '}';
    }
}


