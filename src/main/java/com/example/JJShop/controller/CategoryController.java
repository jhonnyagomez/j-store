package com.example.JJShop.controller;

import com.example.JJShop.model.Category;
import com.example.JJShop.model.Item;
import com.example.JJShop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/shop/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(categoryService.createCategory(category));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Integer id) {
        return ResponseEntity
                .ok()
                .body(categoryService.getCategoryById(id));
    }

    @PostMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category, @PathVariable Integer id) {
        return ResponseEntity
                .ok()
                .body(categoryService.updateCategory(category, id));
    }

    @GetMapping
    public ResponseEntity<List<Category>> allCategories() {
        return ResponseEntity
                .ok()
                .body(categoryService.findAllCategories());
    }

    @GetMapping("/getItems/{categoryId}")
    public ResponseEntity<List<Item>> getAllCategoryItems(@PathVariable Integer categoryId) {
        return ResponseEntity
                .ok()
                .body(categoryService.getAllCategoryItems(categoryId));

    }

    @GetMapping("delete/{id}")
    public ResponseEntity<Void> deleteCategoryById(@PathVariable Integer id) {
        categoryService.deleteCategoryById(id);
        return ResponseEntity.noContent().build();
    }
}
