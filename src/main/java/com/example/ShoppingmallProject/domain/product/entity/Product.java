package com.example.ShoppingmallProject.domain.product.entity;

import com.example.ShoppingmallProject.domain.category.entity.Category;
import com.example.ShoppingmallProject.domain.product.dto.ProductDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Product")
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int price;
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public Product(){};

    public Product(String name, int price, String description, Category category) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    public ProductDTO convertToDTO(){
        return new ProductDTO(id, name, price, description, category.getId());
    }
}
