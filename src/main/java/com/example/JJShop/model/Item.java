package com.example.JJShop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
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
    @JsonBackReference
    //@JsonIgnore
    private Category category;
}
