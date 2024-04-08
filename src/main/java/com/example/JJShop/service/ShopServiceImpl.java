package com.example.JJShop.service;

import com.example.JJShop.model.Item;
import com.example.JJShop.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopRepository shopRepository;

    @Override
    public Item createItem(Item item)  {
        return shopRepository.save(item);
    }

    @Override
    public Item updateItem(Item updatedItem, Long id) {
        Optional<Item> dbItem = shopRepository.findById(id);
        if (dbItem.isEmpty()){
            return null;
        }
        //Setters
        return shopRepository.save(dbItem.get());
    }

    @Override
    public Item getItemById(Long id) {
        Optional<Item> user = shopRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public List<Item> getItems() {
        return (List<Item>) shopRepository.findAll();
    }

    @Override
    public List<Item> getAllCategoryItems(Long id) {
        return null;
    }
}
