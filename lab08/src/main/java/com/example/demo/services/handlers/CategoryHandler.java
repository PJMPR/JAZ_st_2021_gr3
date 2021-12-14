package com.example.demo.services.handlers;

import com.example.demo.controllers.DTO.FilmDTO;
import com.example.demo.services.CategoryService;

import java.util.List;

public class CategoryHandler extends Handler {
    CategoryService categoryService;

    public CategoryHandler(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public boolean check(FilmDTO filmDTO) {
        if (filmDTO.getFilmCategories() != null) {
            List<String> categories = categoryService.getAllCategories();
            for (String category : filmDTO.getFilmCategories()) {
                if (categories.stream().noneMatch(s -> s.equalsIgnoreCase(category))) {
                    categoryService.addCategory(category);
                }
            }
        }
        return checkNext(filmDTO);
    }
}