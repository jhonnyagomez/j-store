package com.example.JJShop.controller;

import com.example.JJShop.model.Category;
import com.example.JJShop.model.Item;
import com.example.JJShop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/shop/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Integer id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping("/{id}")
    public Category updateCategory(@RequestBody Category category, @PathVariable Integer id) {
        return categoryService.updateCategory(category, id);
    }

    @GetMapping
    public List<Category> allCategories() {
        return categoryService.findAllCategories();
    }

    @GetMapping("/{categoryId}")
    public List<Item> getAllCategoryItems(@PathVariable Integer categoryId) {
        return categoryService.getAllCategoryItems(categoryId);
    }

}
