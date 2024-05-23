package com.example.JJShop.repository;

import com.example.JJShop.model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository <Category, Integer>  {
    Optional<Category> findByCategoryName(String categoryName);
    Optional<Category> findByCategoryNameAndCategoryIdNot(String categoryName, Integer categoryId);


}
