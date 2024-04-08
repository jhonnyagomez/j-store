package com.example.JJShop.repository;

import com.example.JJShop.model.Item;
import org.springframework.data.repository.CrudRepository;

public interface ShopRepository extends CrudRepository<Item, Long> {

}
