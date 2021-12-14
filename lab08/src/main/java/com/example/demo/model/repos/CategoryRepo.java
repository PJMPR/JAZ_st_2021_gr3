package com.example.demo.model.repos;

import com.example.demo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {
    @Query("SELECT DISTINCT c.name FROM Category c")
    List<String> findAllDistinctCategories();
}