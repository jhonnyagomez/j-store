package com.example.JJShop.service;

import com.example.JJShop.model.Item;
import com.example.JJShop.repository.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ItemServiceImplTest {

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemServiceImpl itemService;

    private Item item;

    @BeforeEach
    public void setUp() {

        item = Item.builder()
                .itemName("Sample Item 1")
                .itemDescription("This is a sample item description 1.")
                .itemPrice(10.50f)
                .isItemAvailable(true)
                .itemStock(100)
                .build();
    }

    @Test
    public void givenItemWhenCreateItemIsCalledShouldCreateNewItem() {
        when(itemRepository.findByItemName(item.getItemName())).thenReturn(Optional.empty());
        when(itemRepository.save(item)).thenReturn(item);

        Item savedItem = itemService.createItem(item);

        assertEquals(item, savedItem);
    }

    @Test
    public void givenItemIdWhenFindByIdIsCalledShouldReturnItem() {
        Long id = 1L;
        when(itemRepository.findById(id)).thenReturn(Optional.of(item));

        Item actualItem = itemService.getItemById(id);

        assertEquals(item, actualItem);
    }

    @Test
    public void whenFindAllItemsIsCalledShouldReturnAListOfItems() {

        when(itemRepository.findAll()).thenReturn(Collections.singletonList(item));

        List<Item> actualItems = itemService.findAllItems();

        assertEquals(Collections.singletonList(item), actualItems);
    }

    @Test
    public void givenItemIdWhenDeleteItemByIdIsCalledShouldCallDeleteById() {
        Long id = 1L;
        when(itemRepository.findById(id)).thenReturn(Optional.of(item));
        itemService.deleteItemById(id);

        verify(itemRepository).deleteById(id);
    }
}
