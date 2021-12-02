package com.example.demo.repositories;

import com.example.demo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(nativeQuery = true, value = "select customer.customer_id, first_name, last_name, sum(payment.amount) as spent_money from customer join payment on customer.customer_id = payment.customer_id group by customer.customer_id order by spent_money desc limit 10")
    List<Object[]> get10CustomersByMostSpentMoney();

    @Query(nativeQuery = true, value = "select customer.customer_id, first_name, last_name, count(payment.amount) as movies_watched from customer join payment on customer.customer_id = payment.customer_id group by customer.customer_id order by movies_watched desc limit 10")
    List<Object[]> get10CustomersByMostMoviesWatched();
}
