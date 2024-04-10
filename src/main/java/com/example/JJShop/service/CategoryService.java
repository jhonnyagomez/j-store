package com.example.JJShop.service;

import com.example.JJShop.model.Category;
import com.example.JJShop.model.Item;

import java.util.List;

public interface CategoryService {
    Category createCategory(Category category);

    Category updateCategory(Category updatedCategory, Integer id);

    Category getCategoryById(Integer id);

    List<Item> getAllCategoryItems(Integer id);
}
