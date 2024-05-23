package com.example.JJShop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @NotNull(message = "Please provide the item name")
    @Size(min = 2, max = 200, message = "The text length must be between 2 and 200")
    private String itemName;
    @Column(name = "item_description")
    @NotNull(message = "Please provide an item description")
    @Size(min = 5, max = 200, message = "The text length must be between 5 and 200")
    private String itemDescription;
    @Column(name = "item_price")
    @NotNull(message = "Please provide the item price")
    @DecimalMin(value = "0.01", message = "Price must be greater than 0")
    private Float itemPrice;
    @Column(name = "is_item_available")
    private Boolean isItemAvailable;
    @Column(name = "item_stock")
    private Integer itemStock;

    @ManyToOne
    @JoinColumn(referencedColumnName = "category_id")
    @JsonBackReference
    private Category category;
}
