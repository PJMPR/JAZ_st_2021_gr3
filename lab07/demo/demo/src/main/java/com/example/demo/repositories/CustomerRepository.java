package com.example.demo.repositories;

import com.example.demo.controllers.CustomerRankingEntry;
import com.example.demo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select customer.customer_id, first_name, last_name, sum(payment.amount) as value from customer, payment where customer.customer_id = payment.customer_id group by customer.customer_id")
    List<CustomerRankingEntry<Double>> getAllWithSumPaymentAmount();
}
