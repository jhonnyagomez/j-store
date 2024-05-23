package com.example.JJShop.controller;

import com.example.JJShop.model.Category;
import com.example.JJShop.model.Item;
import com.example.JJShop.service.CategoryService;
import com.example.JJShop.service.ItemService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Item> createItem(@RequestBody @Valid Item item) {
        Integer categoryId = item.getCategory().getCategoryId();
        Category category = categoryService.getCategoryById(categoryId);

        if (category != null) {
            item.setCategory(category);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(itemService.createItem(item));
        } else {
            return null;
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable @Min(1) Long id) {
        return ResponseEntity
                .ok()
                .body(itemService.getItemById(id));
    }

    @GetMapping
    public ResponseEntity<List<Item>> allItems() {
        return ResponseEntity
                .ok()
                .body(itemService.findAllItems());
    }

    @PostMapping("/{id}")
    public ResponseEntity<Item> updateItem(@RequestBody @Valid Item Item, @PathVariable @Min(1) Long id) {
        return ResponseEntity
                .ok()
                .body(itemService.updateItem(Item, id));
    }

    @GetMapping("delete/{id}")
    public ResponseEntity<Void> deleteItemById(@PathVariable @Min(1) Long id) {
        itemService.deleteItemById(id);
        return ResponseEntity.noContent().build();
    }
}
