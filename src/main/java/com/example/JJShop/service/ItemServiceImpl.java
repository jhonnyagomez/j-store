package com.example.JJShop.service;

import com.example.JJShop.model.Item;
import com.example.JJShop.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item updateItem(Item updatedItem, Long id) {
        Optional<Item> dbItem = itemRepository.findById(id);
        if (dbItem.isEmpty()) {
            return null;
        }

        dbItem.get().setItemDescription(updatedItem.getItemDescription());
        dbItem.get().setItemPrice(updatedItem.getItemPrice());
        //TODO Podríamos hacer que el itemAvailable se agregue true o false dependiendo del STOCK, pero no sé si este sea el lugar correcto para hacerlo
        dbItem.get().setIsItemAvailable(updatedItem.getIsItemAvailable());
        dbItem.get().setItemStock(updatedItem.getItemStock());
        return itemRepository.save(dbItem.get());
    }

    @Override
    public Item getItemById(Long id) {
        Optional<Item> item = itemRepository.findById(id);
        return item.orElse(null);
    }

    @Override
    public List<Item> findAllItems() {
        return (List<Item>) itemRepository.findAll();
    }

}
