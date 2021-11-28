package pjatk.pl.lab06.Loan;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TimeTable {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private double amount;
        private int installmentCount;
        private double percentage;
        private double fixedRate;
        private InstallmentType installmentType;

        @OneToMany
        @JoinColumn(name = "timetable_id")
        private List<Installment> installments = new ArrayList<>();

        public TimeTable(){}

    public TimeTable(Long id, double amount, int installmentCount, double percentage, double fixedRate, InstallmentType installmentType) {
        this.id = id;
        this.amount = amount;
        this.installmentCount = installmentCount;
        this.percentage = percentage;
        this.fixedRate = fixedRate;
        this.installmentType = installmentType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public double getFixedRate() {
        return fixedRate;
    }

    public void setFixedRate(double fixedRate) {
        this.fixedRate = fixedRate;
    }

    public InstallmentType getInstallmentType() {
        return installmentType;
    }

    public void setInstallmentType(InstallmentType installmentType) {
        this.installmentType = installmentType;
    }

    public List<Installment> getInstallments() {
        return installments;
    }

    public void setInstallments(List<Installment> installments) {
        this.installments = installments;
    }
}
