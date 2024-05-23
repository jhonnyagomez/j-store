package com.example.JJShop.service;

import com.example.JJShop.exceptions.AlreadyCreatedException;
import com.example.JJShop.exceptions.NotFoundException;
import com.example.JJShop.model.Item;
import com.example.JJShop.model.enums.ErrorMessages;
import com.example.JJShop.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService  {
    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item createItem(Item item) {
        Optional<Item> itemFindByItemName = itemRepository.findByItemName(item.getItemName());
        if (itemFindByItemName.isPresent()){
            throw new AlreadyCreatedException(ErrorMessages.NAME_EXISTS.getMessage());
        }
        return itemRepository.save(item);
    }

    @Override
    public Item updateItem(Item updatedItem, Long id) {
        Optional<Item> dbItem = itemRepository.findById(id);
        if (dbItem.isEmpty()) {
            throw new NotFoundException(ErrorMessages.NAME_NOT_FOUND.getMessage());
        }
        Optional<Item> itemFindByItemName = itemRepository.findByItemNameAndItemIdNot(updatedItem.getItemName(), id);
        if (itemFindByItemName.isPresent()){
            throw new AlreadyCreatedException(ErrorMessages.NAME_EXISTS.getMessage());
        }

        dbItem.get().setItemName(updatedItem.getItemName());
        dbItem.get().setItemDescription(updatedItem.getItemDescription());
        dbItem.get().setItemPrice(updatedItem.getItemPrice());
        dbItem.get().setIsItemAvailable(updatedItem.getIsItemAvailable());
        dbItem.get().setItemStock(updatedItem.getItemStock());
        dbItem.get().setCategory(updatedItem.getCategory());
        return itemRepository.save(dbItem.get());
    }

    @Override
    public Item getItemById(Long id) {
        Optional<Item> item = itemRepository.findById(id);
        if (item.isEmpty()){
            throw new NotFoundException(ErrorMessages.NAME_NOT_FOUND.getMessage());
        }
        return item.get();
    }

    @Override
    public List<Item> findAllItems() {
        return (List<Item>) itemRepository.findAll();
    }

    @Override
    public void deleteItemById(Long id) {
        itemRepository.deleteById(id);
    }

}
