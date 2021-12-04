package com.example.demo.repositories;

import com.example.demo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(nativeQuery = true, value = "select customer.customer_id, first_name, last_name, sum(payment.amount) as spent from customer join payment on customer.customer_id = payment.customer_id group by customer.customer_id order by spent desc limit 10")
    List<CustomerRecords.CustomerRankingBySpentMoneyEntry> get10CustomersByMostSpentMoney();

    @Query(nativeQuery = true, value = "select customer.customer_id, first_name, last_name, count(payment.amount) as watched from customer join payment on customer.customer_id = payment.customer_id group by customer.customer_id order by watched desc limit 10")
    List<CustomerRecords.CustomerRankingByWatchedMoviesEntry> get10CustomersByMostMoviesWatched();

    @Query(nativeQuery = true, value = "select month(rental_date) as month, count(rental_id) as rentMovies from rental group by month")
    List<CustomerRecords.MonthRentActivityEntry> getRentMoviesByMonth();

    @Query(nativeQuery = true, value = "select month(rental_date) as month, count(rental_id) as rentMovies from rental where customer_id = :#{#customer_id} group by month")
    List<CustomerRecords.MonthRentActivityEntry> getRentMoviesByMonthForUser(@Param("customer_id") final int customerId);

    @Query(nativeQuery = true, value = "select month(rental_date) as month, count(rental_id) as rentMovies from rental where year(rental_date) = :#{#year} group by month")
    List<CustomerRecords.MonthRentActivityEntry> getRentMoviesByMonthForYear(@Param("year") final int year);

    @Query(nativeQuery = true, value = "select month(rental_date) as month, count(rental_id) as rentMovies from rental where year(rental_date) = :#{#year} and customer_id = :#{#customer_id} group by month")
    List<CustomerRecords.MonthRentActivityEntry> getRentMoviesByMonthForYearAndUser(@Param("customer_id") final int customerId, @Param("year") final int year);
}
