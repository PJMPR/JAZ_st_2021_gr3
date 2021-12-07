package com.example.demo.repos;

import com.example.demo.data.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepo extends JpaRepository<Rental, Integer> {
}
