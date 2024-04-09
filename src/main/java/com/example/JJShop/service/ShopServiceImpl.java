package com.example.JJShop.service;

import com.example.JJShop.model.Category;
import com.example.JJShop.model.Item;
import com.example.JJShop.repository.CategoryRepository;
import com.example.JJShop.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ShopServiceImpl implements ShopService {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Item createItem(Item item)  {
        return itemRepository.save(item);
    }


    @Override
    public Item updateItem(Item updatedItem, Long id) {
        Optional<Item> dbItem = itemRepository.findById(id);
        if (dbItem.isEmpty()){
            return null;
        }

        //Setters
        return itemRepository.save(dbItem.get());
    }

    @Override
    public Item getItemById(Long id) {
        Optional<Item> item = itemRepository.findById(id);
        return item.orElse(null);
    }

    @Override
    public List<Category> getAllCategoryItems(Long id) {
        return null;
    }

    @Override
    public List<Item> findAllItems() {
        return (List<Item>) itemRepository.findAll();
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category updatedCategory, Integer id) {
        Optional<Category> dbCategory = categoryRepository.findById(id);
        if (dbCategory.isEmpty()){
            return null;
        }

        //Setters
        return categoryRepository.save(dbCategory.get());
    }

    @Override
    public Category getCategoryById(Integer id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.orElse(null);
    }

}
