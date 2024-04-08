package com.example.JJShop.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long itemId;
    @Column(name = "item_name")
    private String itemName;
    @Column(name = "item_description")
    private String itemDescription;
    @Column(name = "item_price")
    private Float itemPrice;
    @Column(name = "is_item_available")
    private Boolean isItemAvailable;
    @Column(name = "item_stock")
    private Integer itemStock;

    @ManyToOne
    @JoinColumn(referencedColumnName = "category_id")
    private Category category;
}
