package com.example.ShoppingmallProject.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existsByName(String name);

    Optional<Product> findByName(String name);
    Optional<Product> findById(long id);

//    public List<Product> findProducts(int limit, int currentPage) {
//        // map을 string으로 바꿨다가 다시 list로 바꿈
//        // map에서 list로 바로 안 바뀌기 때문!!
//        return product_table.values().stream().toList();
//    }
//
//    public List<Product> findProducts(int limit, int currentPage, int categoryId) {
//        List<Product> resultProducts = new ArrayList<>();
//
//        for (Product product : product_table.values()) {
//            if (product.getCategoryId() == categoryId)
//                resultProducts.add(product);
//        }
//
//        return resultProducts;
//    }
//
//    public void deleteProduct(int id) {
//        product_table.remove(id);
//    }
//
//    public void deleteProducts(List<Integer> productIds) {
//        for (int idx = 0; idx < productIds.size(); idx++) {
//            product_table.remove(productIds.get(idx));
//        }
//    }

}
