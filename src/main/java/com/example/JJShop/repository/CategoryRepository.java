package com.example.JJShop.repository;

import com.example.JJShop.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository <Category, Integer>  {
}
