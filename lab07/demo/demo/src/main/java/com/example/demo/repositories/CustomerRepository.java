package com.example.demo.repositories;

import com.example.demo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {




    @Query(value = "SELECT "+
                    "* "+
                    "FROM customer "+
                    "JOIN payment "+
                    "ON "+
                    "payment.customer_id=customer.customer_id "+
                    "GROUP BY customer.customer_id "+
                    "ORDER BY sum(payment.amount) "+
                    "limit 10",
    nativeQuery = true)
    List<Customer> top10Customers();
}
