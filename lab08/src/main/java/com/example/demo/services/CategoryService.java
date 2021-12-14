package com.example.demo.services;

import com.example.demo.model.Category;
import com.example.demo.model.repos.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class CategoryService {
    CategoryRepo categoryRepo;

    @Autowired
    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public List<String> getAllCategories() {
        return categoryRepo.findAllDistinctCategories();
    }

    public void addCategory(String category) {
        categoryRepo.save(new Category(category, new Timestamp(new Date().getTime())));
    }
}