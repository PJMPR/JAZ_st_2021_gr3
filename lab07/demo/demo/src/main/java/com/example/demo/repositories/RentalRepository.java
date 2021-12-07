package com.example.demo.repositories;

import com.example.demo.DatabaseModel.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface RentalRepository extends JpaRepository<Rental, Integer> {
}
