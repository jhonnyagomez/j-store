package com.example.JJShop.repository;

import com.example.JJShop.model.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ItemRepository extends CrudRepository<Item, Long> {
    Optional<Item> findByItemName(String itemName);
    Optional<Item> findByItemNameAndItemIdNot(String itemName, Long itemId);

}
