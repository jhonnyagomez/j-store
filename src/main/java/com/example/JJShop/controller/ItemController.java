package com.example.JJShop.controller;

import com.example.JJShop.model.Category;
import com.example.JJShop.model.Item;
import com.example.JJShop.service.CategoryService;
import com.example.JJShop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/shop/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @Autowired
    private CategoryService categoryService;


    @PostMapping
    public Item createItem(@RequestBody Item item) {
        Integer categoryId = item.getCategory().getCategoryId();
        Category category = categoryService.getCategoryById(categoryId);

        if (category != null) {
            item.setCategory(category);
            return itemService.createItem(item);
        } else {
            return null;
        }
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

}
