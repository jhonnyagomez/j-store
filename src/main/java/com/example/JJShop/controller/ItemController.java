package com.example.JJShop.controller;

import com.example.JJShop.model.Item;
import com.example.JJShop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/shop/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

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

}
