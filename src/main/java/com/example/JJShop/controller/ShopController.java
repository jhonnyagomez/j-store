package com.example.JJShop.controller;

import com.example.JJShop.model.Category;
import com.example.JJShop.model.Item;
import com.example.JJShop.service.CategoryService;
import com.example.JJShop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/shop")
public class ShopController {
    @Autowired
    private ItemService itemService;
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public Item createItem(@RequestBody Item item) {
        return itemService.createItem(item);
    }

    @GetMapping("/{id}")
    public Item getItemById(@PathVariable Long id) {
        return itemService.getItemById(id);
    }

    @PostMapping("/{id}")
    public Item updateItem(@RequestBody Item Item, @PathVariable Long id) {
        return itemService.updateItem(Item, id);
    }

    @GetMapping
    public List<Item> allItems() {
        return itemService.findAllItems();
    }
//
//    @PostMapping
//    public Category createCategory(@RequestBody Category category) {
//        return categoryService.createCategory(category);
//    }
//
//    @GetMapping("/{id}")
//    public Category getCategoryById(@PathVariable Integer id) {
//        return categoryService.getCategoryById(id);
//    }
//
//    @PostMapping("/{id}")
//    public Category updateCategory(@RequestBody Category category, @PathVariable Integer id) {
//        return categoryService.updateCategory(category, id);
//    }
//
//    @PostMapping("/{id}")
//    public List<Item> getAllCategoryItems(@PathVariable Integer categoryId) {
//        return categoryService.getAllCategoryItems(categoryId);
//    }

}
