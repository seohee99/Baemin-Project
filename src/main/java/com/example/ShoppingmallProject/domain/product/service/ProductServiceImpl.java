package com.example.ShoppingmallProject.domain.product.service;

import com.example.ShoppingmallProject.domain.category.entity.Category;
import com.example.ShoppingmallProject.domain.category.repository.CategoryRepository;
import com.example.ShoppingmallProject.domain.product.dto.ProductDTO;
import com.example.ShoppingmallProject.domain.product.entity.Product;
import com.example.ShoppingmallProject.domain.product.repository.ProductRepository;
import com.example.ShoppingmallProject.exception.DuplicateNameException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ProductServiceImpl {

    ProductRepository productRepository;
    CategoryRepository categoryRepository;

    @Transactional
    public Product registerProduct(ProductDTO productDTO) {

        Category category = categoryRepository.findById((int) productDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("카테고리가 존재하지 않습니다"));
//        Product product = new Product(productDTO.getName(), productDTO.getPrice(), productDTO.getDescription(), category);
        Product product = productDTO.convertToEntity(category);
        if(productRepository.existsByName(product.getName())){
            throw new DuplicateNameException("이미 존재하는 상품입니다.");
        }

        log.info("service = {}", product);

        productRepository.save(product);
        return productRepository.findByName(product.getName())
                .orElseThrow(() -> new RuntimeException("상품 등록에 실패했습니다."));
    }



    public ProductDTO findProduct(int id) {
        Product resultProduct =  productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 상품이 존재하지 않습니다"));

        return resultProduct.convertToDTO();
    }

//    public List<Product> findProducts(int limit, int currentPage) {
//        return productRepository.findProducts(limit, currentPage);
//    }
//
//    public List<Product> findProducts(int limit, int currentPage, int categoryId) {
//        return productRepository.findProducts(limit, currentPage, categoryId);
//    }
//
//    public void deleteProduct(int id) {
//        productRepository.deleteProduct(id);
//    }
//
//    public void deleteProducts(List<Integer> productIds) {
//        productRepository.deleteProducts(productIds);
//    }
}
