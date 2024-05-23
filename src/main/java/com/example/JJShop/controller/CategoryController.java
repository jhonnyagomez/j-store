package com.example.JJShop.controller;

import com.example.JJShop.model.Category;
import com.example.JJShop.model.Item;
import com.example.JJShop.service.CategoryService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
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
    public ResponseEntity<Category> createCategory(@RequestBody @Valid Category category) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(categoryService.createCategory(category));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable @Min(1) Integer id) {
        return ResponseEntity
                .ok()
                .body(categoryService.getCategoryById(id));
    }

    @PostMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@Valid @RequestBody Category category, @PathVariable @Positive Integer id) {
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
    public ResponseEntity<List<Item>> getAllCategoryItems(@PathVariable @Min(1) Integer categoryId) {
        return ResponseEntity
                .ok()
                .body(categoryService.getAllCategoryItems(categoryId));

    }

    @GetMapping("delete/{id}")
    public ResponseEntity<Void> deleteCategoryById(@PathVariable @Min(1) Integer id) {
        categoryService.deleteCategoryById(id);
        return ResponseEntity.noContent().build();
    }
}
