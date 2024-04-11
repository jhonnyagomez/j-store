package com.example.JJShop.service;

import com.example.JJShop.model.Item;

import java.util.List;

public interface ItemService {

    Item createItem(Item item);

    Item updateItem(Item updatedItem, Long id);

    Item getItemById(Long id);

    List<Item> findAllItems();

    void deleteItemById(Long id);
}
