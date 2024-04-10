package com.example.JJShop.service;

import com.example.JJShop.model.Category;
import com.example.JJShop.model.Item;
import com.example.JJShop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Item> getAllCategoryItems(Integer id) {
        return categoryRepository.findById(id).get().getItemList();
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category updatedCategory, Integer id) {
        Optional<Category> dbCategory = categoryRepository.findById(id);
        if (dbCategory.isEmpty()) {
            return null;
        }

        dbCategory.get().setCategoryName(updatedCategory.getCategoryName());
        return categoryRepository.save(dbCategory.get());
    }

    @Override
    public Category getCategoryById(Integer id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.orElse(null);
    }
}
