package com.example.JJShop.service;

import com.example.JJShop.model.Category;
import com.example.JJShop.model.Item;
import com.example.JJShop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAllCategories() {
        return (List<Category>) categoryRepository.findAll();
    }

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

    @Override
    public void deleteCategoryById(Integer id) {
        categoryRepository.deleteById(id);
    }

}
