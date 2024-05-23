package com.example.JJShop.service;

import com.example.JJShop.model.Category;
import com.example.JJShop.model.Item;
import com.example.JJShop.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CategoryServiceImplTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    private Category category1;
    private Category category2;
    private Category category3;

    @BeforeEach
    public void setUp() {


        category1 = Category.builder()
                .categoryId(1)
                .categoryName("Category 1")
                .itemList(Collections.singletonList(
                        Item.builder()
                                .itemName("Sample Item 1")
                                .itemDescription("This is a sample item description 1.")
                                .itemPrice(10.50f)
                                .isItemAvailable(true)
                                .itemStock(100)
                                .build()))
                .build();

        category2 = Category.builder().categoryId(2).categoryName("Category 2").build();
        category3 = Category.builder().categoryId(3).categoryName("Category 3").build();
    }

    @Test
    public void givenCategoriesWhenCategoryRepositoryFindAllCategoriesIsCalledShouldReturnAllCategoryList() {
        List<Category> expectedCategories = new ArrayList<>();
        expectedCategories.add(category1);
        expectedCategories.add(category2);
        expectedCategories.add(category3);

        when(categoryRepository.findAll()).thenReturn(expectedCategories);

        List<Category> actualCategories = categoryService.findAllCategories();

        assertEquals(expectedCategories, actualCategories);
    }

    @Test
    public void givenCategoryIdWhenCategoryServiceGetAllCategoryIsCalledShouldReturnItemList() {
        Integer id = 1;
        List<Item> expectedItems = category1.getItemList();
        when(categoryRepository.findById(id)).thenReturn(Optional.of(category1));

        List<Item> actualItems = categoryService.getAllCategoryItems(id);

        assertEquals(expectedItems, actualItems);
    }

    @Test
    public void whenCreateCategoryIsCalledShouldCreateCategory() {
        when(categoryRepository.findByCategoryName(category1.getCategoryName())).thenReturn(Optional.empty());
        when(categoryRepository.save(category1)).thenReturn(category1);

        Category savedCategory = categoryService.createCategory(category1);

        assertEquals(category1, savedCategory);
    }

    @Test
    public void givenCategoryIdWhenGetCategoryByIdIsCalledShouldReturnCategory() {
        Integer id = 1;
        when(categoryRepository.findById(id)).thenReturn(Optional.of(category1));

        Category actualCategory = categoryService.getCategoryById(id);

        assertEquals(category1, actualCategory);
    }

    @Test
    public void givenCategoryIdWhenDeleteCategoryByIdIsCalledShouldCallDeleteById() {
        //Teacher
        Integer id = 1;
        categoryService.deleteCategoryById(id);

        verify(categoryRepository).deleteById(id);
    }
}
