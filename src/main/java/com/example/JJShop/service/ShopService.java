package com.example.JJShop.service;

import com.example.JJShop.model.Category;
import com.example.JJShop.model.Item;

import java.util.List;

public interface ShopService {

    Item createItem(Item item);
    Item updateItem(Item updatedItem, Long id);
    Item getItemById(Long id);

    List<Item> findAllItems();

    Category createCategory(Category category);
    Category updateCategory(Category updatedCategory, Integer id);
    Category getCategoryById(Integer id);

    List<Category> getAllCategoryItems(Long id);


}
