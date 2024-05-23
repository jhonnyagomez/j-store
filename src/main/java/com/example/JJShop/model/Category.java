package com.example.JJShop.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "category_id")
    private Integer categoryId;
    @Column(name = "category_name")
    @NotNull(message = "Please provide a name for the category")
    @Size(min = 3, max = 70, message = "The text length must be between 3 and 70")
    private String categoryName;

    @OneToMany(mappedBy = "category")
    @Nullable
    @JsonManagedReference
    private List<Item> itemList;

}
