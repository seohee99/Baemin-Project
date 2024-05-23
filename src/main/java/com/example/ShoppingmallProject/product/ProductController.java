package com.example.ShoppingmallProject.product;


import com.example.ShoppingmallProject.utill.ApiUtils;
import com.example.ShoppingmallProject.utill.Validator;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.example.ShoppingmallProject.utill.ApiUtils.success;

@RestController
@AllArgsConstructor
@Slf4j
public class ProductController {

    ProductService productService;

    // 상품 개별 등록
    @PostMapping("/products")
    public ApiUtils.ApiResult registerProduct(@Valid @RequestBody ProductDTO productDTO){
        Optional<Product> savedproduct = productService.registerProduct(productDTO);
        log.info(savedproduct.toString());

        return success(savedproduct.get().getId());
    }




    // 상품 전체, 카테고리별 조회
//    @GetMapping("/products")
//    public ResponseEntity<List<Product>> findProducts(
//            @RequestParam("limit") int limit,
//            @RequestParam("currentPage") int currentPage,
//            @RequestParam(value = "categoryId", required = false) Integer categoryId
//            ){
//        log.info("limit = {}", limit);
//        log.info("currentPage = {}", currentPage);
//        log.info("categoryId = {}", categoryId);
//        // categoryId가 null이면 전체 조회
//        if(categoryId == null){
//            List<Product> products = productService.findProducts(limit, currentPage);
//            return new ResponseEntity<>(products, HttpStatus.OK);
//        }else {
//            List<Product> products = productService.findProducts(limit, currentPage,categoryId);
//            return new ResponseEntity<>(products, HttpStatus.OK);
//        }
//
//
//    }
//
//    // 상품 개별 조회
//    @GetMapping("/products/{id}")
//    public ResponseEntity<Product> findProduct(@PathVariable(value="id")  int id){
//        if(!Validator.isNumber(id)) {
//            // TODO log INFO 레벨 id type
////            Logger log = LoggerFactory.getLogger(ProductController );
//            log.info(id + "");
//            log.trace(id + "");
//
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//
//
//        Product resultProduct = productService.findProduct(id);
//        if(resultProduct == null)
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        return new ResponseEntity<>(resultProduct,HttpStatus.OK);
//    }
//
//    // 상품 개별 삭제
//    @DeleteMapping("/products/{id}")
//    public ResponseEntity deleteProduct(@PathVariable("id") int id){
//        if(!Validator.isNumber(id)) {
//            log.info(id + "");
//            log.trace(id + "");
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        // 삭제 성공여부 판단하려면 필요한 데이터? => 삭제한 id를 조회해보자
//        productService.deleteProduct(id);
//        // 상품 조회
//        Product product = productService.findProduct(id);
//        // null이면 성공
//        if(product == null)
//            return new ResponseEntity<>(HttpStatus.OK);
//        else
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//
//    }
//
//    // 상품 여러개 삭제
//    @PostMapping("/products/delete")
//    public ResponseEntity deleteProducts(@RequestBody Map<String, List<Integer>> deleteRequest) {
//
//        List<Integer> productIds = deleteRequest.get("productIds");
//
//        if (productIds.isEmpty()) {
//            log.info("productIds가 없습니다");
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//
//        productService.deleteProducts(productIds);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }





}
