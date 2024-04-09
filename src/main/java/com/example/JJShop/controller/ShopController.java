package com.example.JJShop.controller;

import com.example.JJShop.model.Category;
import com.example.JJShop.model.Item;
import com.example.JJShop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/v1/shop")
public class ShopController {
    @Autowired
    private ShopService shopService;
    @PostMapping
    public Item createItem(@RequestBody Item item){
        return shopService.createItem(item);
    }
    @GetMapping("/{id}")
    public Item getItemById(@PathVariable Long id){
        return shopService.getItemById(id);
    }

    @PostMapping("/{id}")
    public Item updateItem(@RequestBody Item Item, @PathVariable Long id){
        return shopService.updateItem(Item, id);
    }

    @GetMapping
    public List<Item> allItems(){
        return shopService.findAllItems();
    }
    @PostMapping
    public Category createCategory(@RequestBody Category category){
        return shopService.createCategory(category);
    }
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Integer id){
        return shopService.getCategoryById(id);
    }

    @PostMapping("/{id}")
    public Category updateCategory(@RequestBody Category category, @PathVariable Integer id){
        return shopService.updateCategory(category, id);
    }

}
