package com.example.ShoppingmallProject.domain.category.repository;

import com.example.ShoppingmallProject.domain.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
