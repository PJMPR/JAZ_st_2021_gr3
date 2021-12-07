package com.example.demo.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
public class Customer {
    private int customerId;
    private String firstName;
    private String lastName;
    private String email;
    private byte active;
    private Timestamp createDate;
    private Timestamp lastUpdate;
    private Collection<Payment> paymentsByCustomerId;
    private Collection<Rental> rentalsByCustomer;

    @Id
    @Column(name = "customer_id")
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "active")
    public byte getActive() {
        return active;
    }

    public void setActive(byte active) {
        this.active = active;
    }

    @Basic
    @Column(name = "create_date")
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "last_update")
    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (customerId != customer.customerId) return false;
        if (active != customer.active) return false;
        if (firstName != null ? !firstName.equals(customer.firstName) : customer.firstName != null) return false;
        if (lastName != null ? !lastName.equals(customer.lastName) : customer.lastName != null) return false;
        if (email != null ? !email.equals(customer.email) : customer.email != null) return false;
        if (createDate != null ? !createDate.equals(customer.createDate) : customer.createDate != null) return false;
        return lastUpdate != null ? lastUpdate.equals(customer.lastUpdate) : customer.lastUpdate == null;
    }

    @Override
    public int hashCode() {
        int result = customerId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (int) active;
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (lastUpdate != null ? lastUpdate.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "customerByCustomerId")
    public Collection<Payment> getPaymentsByCustomerId() {
        return paymentsByCustomerId;
    }

    public void setPaymentsByCustomerId(Collection<Payment> paymentsByCustomerId) {
        this.paymentsByCustomerId = paymentsByCustomerId;
    }

    @OneToMany(mappedBy = "customerByCustomerId")
    public Collection<Rental> getRentalsByCustomer() {
        return rentalsByCustomer;
    }

    public void setRentalsByCustomer(Collection<Rental> rentalsByCustomerId) {
        this.rentalsByCustomer = rentalsByCustomer;
    }

    public BigDecimal amountSpent() {
        BigDecimal sum = BigDecimal.ZERO;
        sum = paymentsByCustomerId.stream().map(Payment::getAmount).reduce(BigDecimal.valueOf(0), BigDecimal::add);
        return sum;
    }

    public int moviesWatched() {
        return paymentsByCustomerId.size();
    }

    public int getRentalsByYear(int year, int month) {
        Timestamp timeFrom = Timestamp.valueOf(year + "-" + month + "-01 00:00:01");
        Timestamp timeTo = Timestamp.valueOf(year + "-" + month + "-31 23:59:59");
        return (int) getRentalsByCustomer().stream().map(Rental::getRentalDate).filter(x -> x.after(timeFrom) && x.before(timeTo)).count();
    }
}
