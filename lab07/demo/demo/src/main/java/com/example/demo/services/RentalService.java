package com.example.demo.services;

import com.example.demo.data.Rental;
import com.example.demo.repos.RentalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Component
public class RentalService {

    public RentalRepo rentalRepo;

    @Autowired
    public RentalService(RentalRepo rentalRepo) {
        this.rentalRepo = rentalRepo;
    }

    public RentalService(){}

    public int getIncomeMonth(int year, int month){
        Timestamp timeBegin = Timestamp.valueOf(year + "-" + month + "-01 00:00:00");
        Timestamp timeEnd = Timestamp.valueOf(year + "-" + month + "-31 23;59:59");
        return rentalRepo.findAll().stream().map(Rental::getPaymentsByRentalId)
                .map(x -> x.stream().filter(y -> y.getPaymentDate().after(timeBegin) && y.getPaymentDate().before(timeEnd)))
                .map(x -> x.map(y -> y.getAmount()).reduce(BigDecimal.ZERO, BigDecimal::add).intValue())
                .reduce(0, Integer::sum);
    }
}
