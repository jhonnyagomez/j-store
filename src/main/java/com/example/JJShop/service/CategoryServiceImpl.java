package com.example.JJShop.service;

import com.example.JJShop.exceptions.AlreadyCreatedException;
import com.example.JJShop.exceptions.NotFoundException;
import com.example.JJShop.model.Category;
import com.example.JJShop.model.Item;
import com.example.JJShop.model.enums.ErrorMessages;
import com.example.JJShop.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAllCategories() {
        List<Category> categories = (List<Category>) categoryRepository.findAll();
        if (categories.isEmpty()) {
            throw new NotFoundException(ErrorMessages.CATEGORY_NOT_FOUND.getMessage());
        }
        return categories;

    }

    @Override
    public List<Item> getAllCategoryItems(Integer id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isEmpty()) {
            throw new NotFoundException(ErrorMessages.CATEGORY_NOT_FOUND.getMessage());
        } else {
            if (category.get().getItemList() != null) {
                if (category.get().getItemList().isEmpty()) {
                    throw new NotFoundException(ErrorMessages.NAME_NOT_EXISTS.getMessage());
                }
            }

        }

        return categoryRepository.findById(id).get().getItemList();
    }

    @Override
    public Category createCategory(Category category) {
        Optional<Category> userFindByCategoryName = categoryRepository.findByCategoryName(category.getCategoryName());
        if (userFindByCategoryName.isPresent()) {
            throw new AlreadyCreatedException(ErrorMessages.CATEGORY_EXISTS.getMessage());
        }
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category updatedCategory, Integer id) {
        Optional<Category> dbCategory = categoryRepository.findById(id);
        if (dbCategory.isEmpty()) {
            throw new NotFoundException(ErrorMessages.CATEGORY_NOT_FOUND.getMessage());
        }
        if (dbCategory.get().getCategoryName().equals(updatedCategory.getCategoryName())) {
            throw new AlreadyCreatedException(ErrorMessages.CATEGORY_EXISTS.getMessage());
        }else {
            dbCategory.get().setCategoryName(updatedCategory.getCategoryName());
        }

        return categoryRepository.save(dbCategory.get());
    }

    @Override
    public Category getCategoryById(Integer id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isEmpty()) {
            throw new NotFoundException(ErrorMessages.CATEGORY_NOT_FOUND.getMessage());
        }
        return category.get();
    }

    @Override
    public void deleteCategoryById(Integer id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isEmpty()) {
            throw new NotFoundException(ErrorMessages.CATEGORY_NOT_FOUND.getMessage());
        } else {
            categoryRepository.deleteById(id);
        }
    }

}
